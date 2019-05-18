package com.photo.api.service.Impl;

import com.photo.api.service.LabelService;
import com.photo.common.enmus.ResultEnum;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.dao.domain.ImgLabel;
import com.photo.dao.domain.Label;
import com.photo.dao.repository.ImgLabelMapper;
import com.photo.dao.repository.LabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class LabelServiceImpl implements LabelService{

    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private ImgLabelMapper imgLabelMapper;

    @Override
    @Transactional
    public Result insertLabel(ImgLabel imgLabel) {
        if(imgLabel.getLa_name()== null)
           return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        imgLabel.setT_i_la_id(UUID.randomUUID().toString());
        Label label =  labelMapper.selectLabelByName(imgLabel.getLa_name());
        if(label != null){
            imgLabel.setLa_id(label.getLa_id());
        }else {
            label = new Label();
            String la_id = UUID.randomUUID().toString();
            label.setLa_id(la_id);
            label.setLa_name(imgLabel.getLa_name());
            int n = labelMapper.insertSelective(label);
            if(n != 1)
                return ResultUtil.error(ResultEnum.ADD_ERROR.getMsg());
            imgLabel.setLa_id(la_id);
        }
        int n = imgLabelMapper.insertSelective(imgLabel);
        if(n == 1)
            return ResultUtil.success(ResultEnum.ADD_SUCCESS.getMsg());

        return ResultUtil.error(ResultEnum.ADD_ERROR.getMsg());
    }

    @Override
    @Transactional
    public Result deleteLabel(ImgLabel imgLabel) {
        if(imgLabel.getT_i_la_id() == null)
            return ResultUtil.error(ResultEnum.DELETE_ERROR.getMsg());
        int  n = imgLabelMapper.deleteByPrimaryKey(imgLabel.getT_i_la_id());
        if(n != 1)
            return ResultUtil.error(ResultEnum.DELETE_ERROR.getMsg());
        return ResultUtil.success(ResultEnum.DELETE_SUCCESS.getMsg());
    }

    @Override
    public Result selectImgLabelByU_id(String u_id) {
        if(u_id == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        List<Map> maps = imgLabelMapper.selectImgLabelByU_id(u_id);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),maps);
    }

    @Override
    public Result recommendLabel() {
        List<Map> list = labelMapper.recommendLabel(1);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),list);
    }
}
