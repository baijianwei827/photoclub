package com.photo.api.controller;

import com.photo.api.service.LabelService;
import com.photo.common.results.Result;
import com.photo.dao.domain.ImgLabel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "api/v1/label")
@Api("标签接口")
public class LabelController{
    @Autowired
    private LabelService labelService;

    /**
     * 添加标签接口
     * @param label
     * @return
     */
    @PostMapping(value = "add")
    @ApiOperation(value = "添加标签接口",httpMethod = "POST")
    @ApiImplicitParam(name = "label",value = "Label实体",dataType = "label",required = true)
    public Result insertLabel(@RequestBody ImgLabel label){
        return labelService.insertLabel(label);
    }


    /**
     * 删除标签
     * @param label
     * @return
     */
    @DeleteMapping("remove")
    @ApiOperation(value = "删除标签接口",httpMethod = "DELETE")
    @ApiImplicitParam(name = "label",value = "Label实体",dataType = "label",required = true)
    public Result removeLabel(@RequestBody ImgLabel label){
        return labelService.deleteLabel(label);
    }

    /**
     * 通过用户ID查找用户下的所有标签
     * @param u_id
     * @return
     */
    @GetMapping("list/{u_id}")
    @ApiOperation(value = "查找标签接口",httpMethod = "GET")
    @ApiImplicitParam(name = "u_id",value = "用户ID",dataType = "STtring",required = true)
    public Result selectLabel(@PathVariable("u_id")String u_id){
        return labelService.selectImgLabelByU_id(u_id);
    }

    /**
     * 首页推荐标签
     * @return
     */
    @GetMapping("recommend")
    @ApiOperation(value = "首页推荐标签接口",httpMethod = "GET")
    public Result recommendLabel(){
        return labelService.recommendLabel();
    }

}
