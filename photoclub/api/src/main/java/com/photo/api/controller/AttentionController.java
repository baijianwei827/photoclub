package com.photo.api.controller;

import com.photo.api.service.AttentionService;
import com.photo.common.results.Result;
import com.photo.dao.domain.Attention;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/attention")
public class AttentionController{
    @Autowired
    private AttentionService attentionService;

    /**
     * 添加关注
     * @param attention
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "添加关注",httpMethod = "POST")
    @ApiImplicitParam(name = "attention",value = "关注实体",dataType = "Attention",required = true)
    public Result insertAttention(@RequestBody Attention attention){
        return attentionService.insertAttention(attention);
    }

    /**
     * 取消关注
     * @param attention
     * @return
     */
    @DeleteMapping("remove")
    @ApiOperation(value = "取消关注接口",httpMethod = "DELETE")
    @ApiImplicitParam(name = "attention",value = "关注实体",dataType = "Attention",required = true)
    public Result removeAttention(@RequestBody Attention attention){
        return attentionService.removeAttention(attention);
    }

    /**
     * 查询用户关注
     * @param u_id
     * @param type
     * @return
     */
    @GetMapping("select/{u_id}/{type}")
    @ApiOperation(value = "查询用户关注接口",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "u_id",value = "用户ID",dataType = "String",required = true),
            @ApiImplicitParam(name = "type",value = "类型",dataType = "Integer",required = true)
    })
    public Result removeAttention(@PathVariable("u_id") String  u_id,@PathVariable("type")Integer type){
        return attentionService.selectAttentionByU_id(u_id,type);
    }

    /**
     * 查询具体用户关注
     * @param u_id
     * @param by_u_id
     * @return
     */
    @GetMapping("info/{u_id}/{by_u_id}")
    @ApiOperation(value = "查询具体用户关注",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "u_id",value = "用户ID",dataType = "String",required = true),
            @ApiImplicitParam(name = "by_u_id",value = "被关注ID",dataType = "String",required = true)
    })
    public Result removeAttention(@PathVariable("u_id") String  u_id,@PathVariable("by_u_id")String by_u_id){
        return attentionService.selectAttentionByU_idBy_id(u_id,by_u_id);
    }

    /**
     * 查询粉丝
     * @param u_id
     * @return
     */
    @GetMapping("bean/{u_id}")
    @ApiOperation(value = "查询用户粉丝",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "u_id",value = "用户ID",dataType = "String",required = true)
    })
    public Result removeAttention(@PathVariable("u_id") String  u_id){
        return attentionService.selectBeanByU_id(u_id);
    }
}
