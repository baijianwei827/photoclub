package com.photo.api.service.Impl;

import com.github.pagehelper.PageHelper;
import com.photo.api.service.SpecialService;
import com.photo.common.enmus.ResultEnum;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.common.tools.PageInfo;
import com.photo.common.tools.PageUtil;
import com.photo.dao.domain.Special;
import com.photo.dao.repository.ImageMapper;
import com.photo.dao.repository.ImgLabelMapper;
import com.photo.dao.repository.SpecialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SpecialServiceImpl implements SpecialService {

    @Autowired
    private SpecialMapper specialMapper;
    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private ImgLabelMapper imgLabelMapper;

    @Override
    @Transactional
    public Result insertSpecial(Special special) {
        if(special == null || special.getU_id() == null||
                special.getImg_cover()==null || special.getT_id()==null
                ||special.getSp_name()==null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        special.setSp_id(UUID.randomUUID().toString());
        int n = specialMapper.insertSelective(special);
        if(n == 1)
            return ResultUtil.success(ResultEnum.ADD_SUCCESS.getMsg());
        return ResultUtil.error(ResultEnum.ADD_ERROR.getMsg());
    }

    @Override
    @Transactional
    public Result removeSpecial(Special special) {
        if(special == null || special.getU_id() == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        int n = specialMapper.deleteByPrimaryKey(special.getSp_id());
        if(n == 1)
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS.getMsg());
        return ResultUtil.error(ResultEnum.DELETE_ERROR.getMsg());
    }

    @Override
    @Transactional
    public Result updateSpecial(Special special) {
        if(special == null || special.getU_id() == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        int n = specialMapper.updateByPrimaryKeySelective(special);
        if(n == 1)
            return ResultUtil.success(ResultEnum.UPDATE_SUCCESS.getMsg());
        return ResultUtil.error(ResultEnum.UPDATE_ERROR.getMsg());
    }

    @Override
    public Result selectSpecialByU_id(String u_id, Integer sortType,String sp_name,Integer pageNum,Integer pageSize){
        if(u_id == null || sortType == null|| pageNum == null ||
                pageSize == null  )
            return ResultUtil.error(ResultEnum.ILLEGAL_ARGUMENT.getMsg());
        PageUtil pageUtil = new PageUtil(pageNum,pageSize);
        int total = specialMapper.selectSpecialByU_idCount( u_id, sp_name, sortType);
        List<Map> mapList = specialMapper.selectSpecialByU_id(
                u_id,
                sp_name,
                sortType,
                pageUtil.getStartIndex(),
                pageUtil.getEndIndex());
        mapList = getImgMap(mapList);
        pageUtil.setList(mapList,total);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),pageUtil.getList());
    }

    @Override
    public Result selectSpecialByT_idAndName(Integer t_id, String name, Integer sortType,Integer pageNum,Integer pageSize) {
        if( sortType == null|| pageNum == null ||
                pageSize == null  )
            return ResultUtil.error(ResultEnum.ILLEGAL_ARGUMENT.getMsg());
        PageUtil pageUtil = new PageUtil(pageNum,pageSize);
        int total = specialMapper.selectSpecialByT_idAndNameCount(t_id,name,sortType);
        List<Map> mapList = specialMapper.selectSpecialByT_idAndName(t_id,name,sortType,pageUtil.getStartIndex(),pageUtil.getEndIndex());
        mapList = getImgMap(mapList);
        pageUtil.setList(mapList,total);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),pageUtil.getList());
    }
    @Override
    public Result selectSpecialByS_id(String s_id,Integer pageNum,Integer pageSize) {
        if(s_id == null){
            return ResultUtil.error(ResultEnum.ILLEGAL_ARGUMENT.getMsg());
        }
        Map map = specialMapper.selectSpecialByS_id(s_id);
        if(map == null)
            return ResultUtil.error(ResultEnum.SELECT_ERROR.getMsg());
         PageUtil pageUtil = new PageUtil(pageNum,pageSize);
         int total = imageMapper.selectImageInfoByS_idCount(s_id);
         List<Map> images = imageMapper.selectImageInfoByS_id(s_id,pageUtil.getStartIndex(),pageUtil.getEndIndex());
         for (Map map1:images){
             String im_id = (String) map1.get("im_id");
             List<Map> labels =  getLabelMap(im_id);
             map1.put("labels",labels);
         }
         pageUtil.setList(images,total);
         map.put("images",images);
         map.put("pageNum", pageNum);
         map.put("pageSize", pageSize);
         map.put("pages",pageUtil.getTotalPage());
         map.put("total",total);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),map);
    }

    @Override
    public Result selectSpecialRecommend() {
        List<Map> maps = specialMapper.selectSpecialRecommend(1);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),maps);
    }

    @Override
    public Result selectAllSpecialByU_id(String u_id) {
        if(u_id == null)
            return ResultUtil.error(ResultEnum.SELECT_ERROR.getMsg());
        List<Map> maps = specialMapper.selectAllSpecialByU_id(u_id);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),maps);
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
        System.out.println(mapList);
        return mapList;
    }

    public List<Map> getLabelMap(String im_id){
        List<Map> maps = imgLabelMapper.selectImgLabel(im_id);
        return maps;
    }
}
