package com.photo.api.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.photo.api.params.CommentParams;
import com.photo.api.service.CommentService;
import com.photo.common.enmus.ResultEnum;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.common.tools.PageUtil;
import com.photo.dao.domain.Comment;
import com.photo.dao.repository.CommentMapper;
import com.photo.dao.repository.SpecialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private SpecialMapper specialMapper;
    @Override
    @Transactional
    public Result insertComment(Comment comment) {
        if(comment.getSp_id() == null || comment.getU_id() == null || comment.getContent() == null)
            return ResultUtil.success(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        comment.setCo_id(UUID.randomUUID().toString());
        comment.setCo_time(new Timestamp(new Date().getTime()));
        int n = commentMapper.insertSelective(comment);
        if(n == 1){
            specialMapper.UpdateSpecialComment(1,comment.getSp_id());
            return ResultUtil.success(ResultEnum.ADD_SUCCESS.getMsg());
        }
        return ResultUtil.error(ResultEnum.ADD_ERROR.getMsg());
    }

    @Override
    @Transactional
    public Result removeComment(Comment comment) {
        if(comment.getCo_id() == null)
            return ResultUtil.error(ResultEnum.PARAMTER_NOT_NULL.getMsg());
        if(commentMapper.selectByPrimaryKey(comment.getCo_id()) == null)
            return ResultUtil.error(ResultEnum.DELETE_ERROR.getMsg());
        int n = commentMapper.deleteByPrimaryKey(comment.getCo_id());
        System.out.println(n);
        if(n == 1){
            specialMapper.UpdateSpecialComment(-1,comment.getSp_id());
            return ResultUtil.success(ResultEnum.DELETE_SUCCESS.getMsg());
        }
        return ResultUtil.error(ResultEnum.DELETE_ERROR.getMsg());
    }

    @Override
    public Result selectCommentByS_id(CommentParams commentParams) {
        System.out.println(commentParams);
        if(commentParams.getSp_id() == null || commentParams.getPageNum() == null || commentParams.getPageSize() == null)
            return ResultUtil.error(ResultEnum.SELECT_ERROR.getMsg());
        PageUtil pageUtil = new PageUtil(commentParams.getPageNum(),commentParams.getPageSize());
        int total = commentMapper.selectCommentByS_idCount(commentParams.getSp_id());
        List<Map> maps =  commentMapper.selectCommentByS_id(commentParams.getSp_id(),pageUtil.getStartIndex(),pageUtil.getEndIndex());
        pageUtil.setList(maps,total);
        return ResultUtil.success(ResultEnum.SELECT_SUCCESS.getMsg(),pageUtil.getList());
    }
}
