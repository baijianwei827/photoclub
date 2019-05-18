package com.photo.api.controller;

import com.photo.api.params.SpecialParams;
import com.photo.api.service.SpecialService;
import com.photo.common.results.Result;
import com.photo.dao.domain.Special;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/special")
@Api(value ="专辑列表API")
public class SpecialController{
    @Autowired
    private SpecialService specialService;


    /**
     * 添加专辑
     * @param special
     * @return
     */
    @PostMapping(value = "token/add")
    @ApiOperation(value = "添加专辑接口",httpMethod = "POST")
    @ApiImplicitParam(name = "special",value = "专辑实体",dataType = "Special",required = true)
    public Result insertSpecial(@RequestBody Special special){
        return specialService.insertSpecial(special);
    }

    /**
     * 修改专辑
     * @param special
     * @return
     */
    @PutMapping(value = "token/update")
    @ApiOperation(value = "修改专辑接口",httpMethod = "PUT")
    @ApiImplicitParam(name = "special",value = "专辑实体",dataType = "Sepcial",required = true)
    public Result updateSpecial(@RequestBody Special special){
        return specialService.updateSpecial(special);
    }

    /**
     * 删除专辑
     * @param special
     * @return
     */
    @PutMapping(value = "token/remove")
    @ApiOperation(value = "删除专辑接口",httpMethod = "DELETE")
    @ApiImplicitParam(name = "special",value = "专辑实体",dataType = "Sepcial",required = true)
    public Result removeSpecial(@RequestBody Special special){
        return specialService.removeSpecial(special);
    }

    /**
     * 通过用户ID查找专辑
     * @return
     */
    @PostMapping(value = "u/list")
    @ApiOperation(value = "通过用户ID查找专辑",httpMethod = "POST")
    public Result selectSpecialByU_id(@RequestBody SpecialParams specialParams){
     return specialService.selectSpecialByU_id(
             specialParams.getU_id(),
             specialParams.getSortType(),
             specialParams.getSp_name(),
             specialParams.getPageNum(),
             specialParams.getPageSize());
    }

    /**
     * 通过类别ID或名称查询并排序
     * @return
     */
    @PostMapping(value = "list")
    @ApiOperation(value = "通过类别ID或名称查询并排序接口",httpMethod = "POST")
    public Result selectSpecialByT_idAndName(@RequestBody SpecialParams specialParams){
        return specialService.selectSpecialByT_idAndName(
                specialParams.getT_id(),
                specialParams.getSp_name(),
                specialParams.getSortType(),
                specialParams.getPageNum(),
                specialParams.getPageSize());
    }

    /**
     * 通过s_id查询专辑
     * @param s_id
     * @return
     */
    @GetMapping("info/{s_id}/{pageNum}/{pageSize}")
    @ApiOperation(value = "通过s_id查询专辑",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s_id",value = "专辑ID",dataType = "String"),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",dataType = "Integer"),
    })
    public Result selectSpecialByS_id(@PathVariable(value = "s_id")String s_id,
                                      @PathVariable("pageNum")Integer pageNum,
                                      @PathVariable("pageSize")Integer pageSize){
        return specialService.selectSpecialByS_id(s_id,pageNum,pageSize);
    }

    /**
     * 首页推荐专辑
     * @return
     */
    @GetMapping("recommend")
    @ApiOperation(value = "首页推荐专辑接口",httpMethod = "GET")
    public Result selectSpecialRecommend(){
        return specialService.selectSpecialRecommend();
    }

    /**
     * 获取用户所有专辑
     * @param u_id
     * @return
     */
    @GetMapping("all/{u_id}")
    @ApiOperation(value = "获取用户所有专辑",httpMethod = "GET")
    public Result selectAllSpecialByU_id(@PathVariable("u_id")String u_id){
        return specialService.selectAllSpecialByU_id(u_id);
    }
}
