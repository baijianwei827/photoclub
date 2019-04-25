package com.photo.api.controller;

import com.photo.api.service.CommentService;
import com.photo.common.results.Result;
import com.photo.dao.domain.Comment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
     * 查找某个专辑下的所有图片
     * @param sp_id
     * @param pageNumm
     * @param pageSize
     * @return
     */
    @GetMapping("list/{sp_id}/{pageNum}/{paeSize}")
    @ApiOperation(value = "查找评论",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="sp_id",value = "专辑ID",dataType = "String",required = true),
            @ApiImplicitParam(name="pageNum",value = "当前页数",dataType = "Integer",required = true),
            @ApiImplicitParam(name="pageSize",value = "每页个数",dataType = "Integer",required = true)
    })
    public Result selectCommentByI_id(@PathVariable("sp_id")String sp_id,
                                      @PathVariable("pageNum")Integer pageNumm,
                                      @PathVariable("paeSize")Integer pageSize){
        return commentService.selectCommentByS_id(sp_id,pageNumm,pageSize);
    }

}
