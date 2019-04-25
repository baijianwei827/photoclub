package com.photo.api.service;

import com.photo.common.results.Result;
import com.photo.dao.domain.Comment;


public interface CommentService {

    /**
     * 添加评论
     * @param comment
     * @return
     */
    Result insertComment(Comment comment);

    /**
     * 删除评论
     * @param comment
     * @return
     */
    Result removeComment(Comment comment);

    /**
     *
     * @param s_id
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result selectCommentByS_id(String s_id,Integer pageNum,Integer pageSize);
}
