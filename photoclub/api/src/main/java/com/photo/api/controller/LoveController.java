package com.photo.api.controller;

import com.photo.api.service.LoveService;
import com.photo.common.results.Result;
import com.photo.dao.domain.Love;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/love")
@Api(value = "点赞接口")
public class LoveController {

    @Autowired
    private LoveService loveService;

    /**
     * 点赞
     * @param love
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "点赞接口",httpMethod = "POST")
    @ApiImplicitParam(name="love",value = "点赞实体",dataType = "Love",required = true)
    public Result insertLove(@RequestBody Love love){
           return loveService.insertLove(love);
    }

    /**
     * 取消点赞
     * @param love
     * @return
     */
    @DeleteMapping("remove")
    @ApiOperation(value = "取消点赞接口",httpMethod = "DELETE")
    @ApiImplicitParam(name="love",value = "点赞实体",dataType = "love",required = true)
    public Result removeLove(@RequestBody Love love){
        return loveService.removeLove(love);
    }
}
