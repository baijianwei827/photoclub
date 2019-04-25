package com.photo.api.service.Impl;

import com.photo.api.service.AttentionService;
import com.photo.common.enmus.ResultEnum;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.dao.domain.Attention;
import com.photo.dao.repository.AttentionMapper;
import com.photo.dao.repository.SpecialMapper;
import com.photo.dao.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AttentionMapper attentionMapper;
    @Autowired
    private SpecialMapper specialMapper;

    @Override
    @Transactional
    public Result insertAttention(Attention attention){
        if(attention.getU_id() == null || attention.getBy_u_id() == null ||attention.getA_type() == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        //设置ID
        attention.setA_id(UUID.randomUUID().toString());
        //判断是否已经关注了，避免二次关注
        if(attentionMapper.selectAttentionByU_idBy_id(attention.getU_id(),attention.getBy_u_id())!=null)
            return ResultUtil.error(ResultEnum.ATTENTION_ERROR.getMsg());
        int n = attentionMapper.insert(attention);
        //判断关注的是人还是专辑，如果是专辑到这里就结束了。
        if(attention.getA_type() == 1 || n == 1){
            specialMapper.UpdateSpecialAttention(1,attention.getBy_u_id());
            return ResultUtil.error(ResultEnum.ATTENTION_SUCCESS.getMsg());
        }
        //成为关注人的粉丝
        Attention bean = new Attention();
        bean.setA_id(UUID.randomUUID().toString());
        bean.setU_id(attention.getBy_u_id());
        bean.setBy_u_id(attention.getU_id());
        int m = attentionMapper.insert(bean);
        if (n == 1 && m ==1){
            //更新用户表中的粉丝和关注数量
            UpdateUserAttention(1,attention.getU_id());
            UpdateUserBean(1,attention.getBy_u_id());
            return ResultUtil.success(ResultEnum.ATTENTION_SUCCESS.getMsg());
        }
        return ResultUtil.error(ResultEnum.ATTENTION_ERROR.getMsg());
    }

    @Override
    @Transactional
    public Result removeAttention(Attention attention) {
        if(attention.getU_id() == null || attention.getBy_u_id() ==null || attention.getA_type()==null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        if(attentionMapper.selectAttentionByU_idBy_id(attention.getU_id(),attention.getBy_u_id())!=null)
            return ResultUtil.error(ResultEnum.NOT_ATTENTION_ERROR.getMsg());
        //取消关注
        int n = attentionMapper.removeAttentionOrBean(attention.getU_id(),attention.getBy_u_id());
        if(attention.getA_type() == 1 || n == 1){
            specialMapper.UpdateSpecialAttention(-1,attention.getBy_u_id());
            return ResultUtil.error(ResultEnum.CANCEL_ATTENTION_SUCCESS.getMsg());
        }
        //解除其粉丝关系
        int m = attentionMapper.removeAttentionOrBean(attention.getBy_u_id(),attention.getU_id());
        if(n == 1&&m == 1){
            //更新用户表中的粉丝和关注数量
            UpdateUserAttention(-1,attention.getU_id());
            UpdateUserBean(-1,attention.getBy_u_id());
            return ResultUtil.success(ResultEnum.CANCEL_ATTENTION_SUCCESS.getMsg());
        }
        return ResultUtil.error(ResultEnum.CANCEL_ATTENTION_ERROR.getMsg());
    }

    @Override
    public Result selectAttentionByU_id(String u_id, Integer type){
        if(u_id == null || type ==null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        List<Map> maps =  attentionMapper.selectAttentionByU_id(u_id,type);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),maps);
    }

    @Override
    public Result selectAttentionByU_idBy_id(String u_id, String by_u_id) {
        if(u_id == null || by_u_id == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        Map map = attentionMapper.selectAttentionByU_idBy_id(u_id,by_u_id);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),map);
    }

    @Override
    public Result selectBeanByU_id(String u_id) {
        if(u_id == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
       List<Map> maps =  attentionMapper.selectBeanByU_id(u_id);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),maps);
    }

    @Override
    public Result selectAttentionSpecailByU_id(String u_id) {
        if(u_id == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        List<Map> maps = attentionMapper.selectAttentionSpecialBySe_id(u_id);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),maps);
    }

    /**
     * 关注个数加减
     * @param type
     * @param u_id
     */
    public void UpdateUserAttention (Integer type,String u_id){
        userMapper.UpdateUserAttention(type,u_id);
    }
    /**
     * 粉丝个数加减
     * @param type
     * @param u_id
     */
    public void UpdateUserBean (Integer type,String u_id){
        userMapper.UpdateUserBean(type,u_id);
    }

}
