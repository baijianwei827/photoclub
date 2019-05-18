package com.photo.api.service.Impl;

import com.github.pagehelper.PageHelper;
import com.photo.api.params.ImageParams;
import com.photo.api.service.ImageService;
import com.photo.api.service.LabelService;
import com.photo.common.enmus.ResultEnum;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.common.tools.AliYunOssUtil;
import com.photo.common.tools.PageInfo;
import com.photo.common.tools.PageUtil;
import com.photo.dao.domain.*;
import com.photo.dao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SpecialMapper specialMapper;
    @Autowired
    private LabelService labelService;
    @Autowired
    private ImgLabelMapper imgLabelMapper;


    @Override
    @Transactional
    public Result insertImage(Image image) {
        if(image == null ){
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        }
        image.setIm_id(UUID.randomUUID().toString());
        image.setIs_top(0);
        image.setComment_nummber(0);
        image.setIm_time(new Date());
        image.setLove_number(0);
        Special special = specialMapper.selectByPrimaryKey(image.getSp_id());
        image.setT_id(special.getT_id());
        int n = imageMapper.insertSelective(image);
        if(n != 1)
            return ResultUtil.error(ResultEnum.ADD_ERROR.getMsg());
        if(image.getImgLabels().size()!=0)
            for(ImgLabel imgLabel:image.getImgLabels()){
                imgLabel.setI_id(image.getIm_id());
                labelService.insertLabel(imgLabel);
            }
            int m = specialMapper.UpdateSpecialImgNumber(1,image.getSp_id());
            if(m != 1)
                return ResultUtil.error(ResultEnum.ADD_ERROR.getMsg());
        return ResultUtil.success(ResultEnum.ADD_SUCCESS.getMsg());
    }

    @Override
    @Transactional
    public Result deleteImage(Image image) {
        if(image.getIm_id() == null){
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        }
        int n =imageMapper.deleteByPrimaryKey(image.getIm_id());
        if(n != 1)
            return ResultUtil.error(ResultEnum.DELETE_ERROR.getMsg());
        int m = specialMapper.UpdateSpecialImgNumber(-1,image.getSp_id());
        return ResultUtil.success(ResultEnum.DELETE_SUCCESS.getMsg());
    }

    @Override
    @Transactional
    public Result updateImage(Image image){
        System.out.println(image);
        if(image.getIm_id() == null || image.getU_id() == null)
            return ResultUtil.error(ResultEnum.UPDATE_ERROR.getMsg());
        int n = imageMapper.updateByPrimaryKeySelective(image);
        imgLabelMapper.deleteLabelByIm_id(image.getIm_id());
        Special special = specialMapper.selectByPrimaryKey(image.getSp_id());
        image.setT_id(special.getT_id());
        if(image.getImgLabels() != null){
            for(ImgLabel imgLabel:image.getImgLabels()){
                imgLabel.setI_id(image.getIm_id());
                labelService.insertLabel(imgLabel);
            }
        }
        if(n != 1)
            return ResultUtil.error(ResultEnum.UPDATE_ERROR.getMsg());
        return ResultUtil.success(ResultEnum.UPDATE_SUCCESS.getMsg());
    }

    @Override
    public Result selectImageByName(String name, Integer pageNum, Integer pageSize, Integer sortType) {
        if(name == null || pageNum == null || pageSize == null || sortType == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        List<Map> maps = imageMapper.selectImageByName(name,sortType);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),maps);
    }

    @Override
    public Result selectImageById(String im_id){
        if(im_id == null)
            return ResultUtil.error(ResultEnum.SELECT_ERROR.getMsg());
        Map map = imageMapper.selectImageByIm_id(im_id);
        List<Map> maps = imgLabelMapper.selectImgLabel(im_id);
        if(map == null)
            return ResultUtil.error(ResultEnum.SELECT_ERROR.getMsg());
        map.put("labelList",maps);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),map);
    }

    @Override
    public Result selectImageByLabel(ImgLabel imgLabel, Integer pageNum, Integer pageSize, Integer sortType) {
        if(imgLabel.getI_id() != null || pageNum == null || pageSize == null ||sortType == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        List<Map> maps= imageMapper.selectImageByLabel_id(imgLabel.getLa_id(),sortType);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),maps);
    }

    @Override
    public Result selectImageByType_id(Integer t_id, Integer pageNum, Integer pageSize, Integer sortType) {
        if( pageNum == null || t_id == null|| pageSize == null ||sortType == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        List<Map> list = imageMapper.selectImageByT_id(t_id,sortType);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),list);
    }
    @Override
    public Result recommendImage(ImageParams imageParams) {
        if(imageParams.getPageNum() == null
                || imageParams.getPageSize() == null
                || imageParams.getSortType() == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        PageUtil pageUtil = new PageUtil(
                imageParams.getPageNum(),
                imageParams.getPageSize());
        int total = imageMapper.recommendImageCount(
                imageParams.getIm_title(),
                imageParams.getIs_top(),
                imageParams.getT_id(),
                imageParams.getSortType());
        List<Map> list = imageMapper.recommendImage(
                imageParams.getIm_title(),
                imageParams.getIs_top(),
                imageParams.getT_id(),
                imageParams.getSortType(),
                pageUtil.getStartIndex(),
                pageUtil.getEndIndex());
        pageUtil.setList(list,total);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),pageUtil.getList());
    }

    @Override
    public Result getSTS() {
        Map map = AliYunOssUtil.getSTS();
        if(map ==null)
            return ResultUtil.error("获取失败!");
        return ResultUtil.success("获取成功!",map);
    }

    @Override
    public Result getIndex() {
        Map<String,Object>  indexMap = new HashMap<>();
        List<User> userList = userMapper.selectUserIsRecommend(1);
        List<Map>  specialList = getImgMap(specialMapper.selectSpecialRecommend(1));
        indexMap.put("userList",userList);
        indexMap.put("speciaList",specialList);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),indexMap);
    }

    @Override
    public Result getImgByU_id(ImageParams imageParams) {
        if(imageParams.getU_id() == null
                || imageParams.getPageNum() == null
                || imageParams.getPageSize() == null
                || imageParams.getSortType() == null) {
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        }
        PageUtil pageUtil = new PageUtil(imageParams.getPageNum(),imageParams.getPageSize());
        int total = imageMapper.selectImageByU_idCount(
                imageParams.getU_id(),
                imageParams.getType(),
                imageParams.getSortType(),
                imageParams.getIm_title());
        List<Map> list = imageMapper.selectImageByU_id(
                imageParams.getU_id(),
                imageParams.getType(),
                imageParams.getSortType(),
                imageParams.getIm_title(),
                pageUtil.getStartIndex(),
                pageUtil.getEndIndex());
        pageUtil.setList(list,total);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),pageUtil.getList());
    }

    /**
     * 解析Map得到查找图片
     * @param mapList
     * @return
     */
    public List<Map> getImgMap(List<Map> mapList){
        List<Map> images;
        for(Map map:mapList){
            String sp_id =(String)map.get("sp_id");
            images =  imageMapper.selectImgByS_id(sp_id);
            map.put("images",images);
        }
        return mapList;
    }
}
