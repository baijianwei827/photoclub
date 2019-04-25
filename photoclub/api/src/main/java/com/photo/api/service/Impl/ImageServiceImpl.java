package com.photo.api.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.photo.api.service.ImageService;
import com.photo.api.service.LabelService;
import com.photo.common.enmus.ResultEnum;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.common.tools.AliYunOssUtil;
import com.photo.dao.domain.Image;
import com.photo.dao.domain.ImgLabel;
import com.photo.dao.domain.TypeName;
import com.photo.dao.domain.User;
import com.photo.dao.repository.ImageMapper;
import com.photo.dao.repository.SpecialMapper;
import com.photo.dao.repository.UserMapper;
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

    @Override
    @Transactional
    public Result insertImage(List<Image> images) {
        if(images.size() == 0){
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        }
        for(Image image:images){
            image.setIm_id(UUID.randomUUID().toString());
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
        }
        return ResultUtil.success(ResultEnum.ADD_SUCCESS.getMsg());
    }

    @Override
    @Transactional
    public Result deleteImage(List<Image> images) {
        if(images.size() == 0){
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        }
        for(Image image:images){
            int n =imageMapper.deleteByPrimaryKey(image.getIm_id());
            if(n != 1)
                return ResultUtil.error(ResultEnum.DELETE_ERROR.getMsg());
            int m = specialMapper.UpdateSpecialImgNumber(-1,image.getSp_id());
            if(m != 1)
                return ResultUtil.error(ResultEnum.DELETE_ERROR.getMsg());
        }
        return ResultUtil.success(ResultEnum.DELETE_SUCCESS.getMsg());
    }

    @Override
    @Transactional
    public Result updateImage(Image image){
        if(image.getIm_id() == null || image.getU_id() == null)
            return ResultUtil.error(ResultEnum.UPDATE_ERROR.getMsg());
        int n = imageMapper.updateByPrimaryKeySelective(image);
        if(n != 1)
            return ResultUtil.error(ResultEnum.UPDATE_ERROR.getMsg());
        return ResultUtil.success(ResultEnum.UPDATE_SUCCESS.getMsg());
    }

    @Override
    public Result selectImageByName(String name, Integer pageNum, Integer pageSize, Integer sortType) {
        if(name == null || pageNum == null || pageSize == null || sortType == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        PageHelper.startPage(pageNum,pageSize);
        List<Map> maps = imageMapper.selectImageByName(name,sortType);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setList(maps);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),pageInfo.getList());
    }

    @Override
    public Result selectImageById(String im_id){
        if(im_id == null)
            return ResultUtil.error(ResultEnum.SELECT_ERROR.getMsg());
        Map map = imageMapper.selectImageByIm_id(im_id);
        if(map == null)
            return ResultUtil.error(ResultEnum.SELECT_ERROR.getMsg());
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),map);
    }

    @Override
    public Result selectImageByLabel(ImgLabel imgLabel, Integer pageNum, Integer pageSize, Integer sortType) {
        if(imgLabel.getI_id() != null || pageNum == null || pageSize == null ||sortType == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        PageHelper.startPage(pageNum,pageSize);
        List<Map> maps= imageMapper.selectImageByLabel_id(imgLabel.getLa_id(),sortType);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setList(maps);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),pageInfo.getList());
    }

    @Override
    public Result selectImageByType_id(Integer t_id, Integer pageNum, Integer pageSize, Integer sortType) {
        if( pageNum == null || t_id == null|| pageSize == null ||sortType == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        PageHelper.startPage(pageNum,pageSize);
        List<Map> list = imageMapper.selectImageByT_id(t_id,sortType);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setList(list);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),pageInfo.getList());
    }

    @Override
    public Result recommendImage() {
        List<Map> list = imageMapper.recommendImage(1);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),list);
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
        List<Map>  imgList = imageMapper.recommendImage(1);
        List<Map>  specialList = getImgMap(specialMapper.selectSpecialRecommend(1));
        indexMap.put("userList",userList);
        indexMap.put("imgList",imgList);
        indexMap.put("speciaList",specialList);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),indexMap);
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
