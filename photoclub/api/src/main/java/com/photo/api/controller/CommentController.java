package com.photo.api.controller;

import com.photo.api.params.CommentParams;
import com.photo.api.service.CommentService;
import com.photo.common.results.Result;
import com.photo.dao.domain.Comment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comment")
@Api("评论接口")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping(value = "add")
    @ApiOperation(value = "添加评论",httpMethod = "POST")
    @ApiImplicitParam(name="comment",value = "评论实体",dataType = "Comment",required = true)
    public Result insertComment(@RequestBody Comment comment){
        return commentService.insertComment(comment);
    }

    /**
     * 删除评论
     * @param comment
     * @return
     */
    @DeleteMapping(value = "remove")
    @ApiOperation(value = "删除评论",httpMethod = "DELETE")
    @ApiImplicitParam(name="comment",value = "评论实体",dataType = "Comment",required = true)
    public Result removeComment(@RequestBody Comment comment){
        return commentService.removeComment(comment);
    }

    /**
     * 查找某个专辑下的所有评论
     * @return
     */
    @PostMapping("list")
    @ApiOperation(value = "查找评论",httpMethod = "POST")
    public Result selectCommentByI_id(@RequestBody CommentParams commentParams){
        return commentService.selectCommentByS_id(commentParams);
    }

}
