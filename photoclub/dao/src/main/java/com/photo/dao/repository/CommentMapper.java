package com.photo.dao.repository;

import com.photo.dao.domain.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int deleteByPrimaryKey(String co_id);
    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insert(Comment record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insertSelective(Comment record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    Comment selectByPrimaryKey(String co_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKey(Comment record);

    /**
     * 查找评论
     * @param s_id
     * @return
     */
    @Select("SELECT * FROM t_comment WHERE s_id=#{s_id}")
    List<Map> selectCommentByS_id(@Param(value = "s_id") String s_id);
}