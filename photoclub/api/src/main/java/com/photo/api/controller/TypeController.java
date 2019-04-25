package com.photo.api.controller;

import com.photo.api.service.TypeNameService;
import com.photo.common.results.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/type")
@Api(value = "类别接口API")
public class TypeController {
    @Autowired
    private TypeNameService typeNameService;

    /**
     * 查找所有TypeName
     * @return
     */
    @GetMapping(value = "all")
    @ApiOperation(value = "查询所有Type名称接口",httpMethod = "GET")
    public Result selectAllTypeName(){
        return typeNameService.selectAllTypeName();
    }
}
