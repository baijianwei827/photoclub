package com.photo.api.service.Impl;

import com.photo.api.service.LoveService;
import com.photo.common.enmus.ResultEnum;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.dao.domain.Love;
import com.photo.dao.repository.ImageMapper;
import com.photo.dao.repository.LoveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoveServiceImpl implements LoveService {
    @Autowired
    private LoveMapper loveMapper;
    @Autowired
    private ImageMapper imageMapper;
    @Override
    public Result insertLove(Love love) {
        if(love.getLo_id() == null || love.getI_id() == null || love.getU_id() == null)
            return ResultUtil.success(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        Map map= loveMapper.selectLoveByI_idAndU_id(love.getU_id(),love.getI_id());
        if(map != null)
            return ResultUtil.error(ResultEnum.ADD_ERROR.getMsg());
        int n = loveMapper.insertSelective(love);
        if(n!=1) {
            imageMapper.UpdateImgLove(1,love.getI_id());
            return ResultUtil.error(ResultEnum.ADD_ERROR.getMsg());
        }
        return ResultUtil.success(ResultEnum.ADD_SUCCESS.getMsg());
    }

    @Override
    public Result removeLove(Love love) {
        if(love.getLo_id() == null || love.getI_id() == null || love.getU_id() == null)
            return ResultUtil.success(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        Map map= loveMapper.selectLoveByI_idAndU_id(love.getU_id(),love.getI_id());
        if(map == null)
            return ResultUtil.error(ResultEnum.DELETE_ERROR.getMsg());
        int n =loveMapper.removeLove(love.getU_id(),love.getI_id());
        if(n!=1){
            return  ResultUtil.error(ResultEnum.DELETE_ERROR.getMsg());
        }
        imageMapper.UpdateImgLove(-1,love.getI_id());
        return ResultUtil.error(ResultEnum.DELETE_SUCCESS.getMsg());
    }
}
