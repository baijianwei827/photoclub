package com.photo.api.controller;

import com.photo.api.service.ImageService;
import com.photo.common.results.Result;
import com.photo.common.results.ResultUtil;
import com.photo.dao.domain.Image;
import com.photo.dao.domain.ImgLabel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/image")
@Api(value = "图片接口")
public class ImageController {

    @Autowired
    private ImageService imageService;

    /**
     * 添加图片
     * @param images
     * @return
     */
    @PostMapping("insert")
    @ApiOperation(value = "添加图片",httpMethod = "POST")
    @ApiImplicitParam(name = "image",value = "图片实体",dataType = "Image",required = true)
    public Result insertImage(@RequestBody List<Image> images){
        return imageService.insertImage( images);
    }

    /**
     * 删除图片
     * @param images
     * @return
     */
    @DeleteMapping("remove")
    @ApiOperation(value = "删除图片",httpMethod = "DELETE")
    @ApiImplicitParam(name = "images",value = "图片列表",dataType = "List<Image>",required = true)
    public Result removeImage(@RequestBody List<Image> images){
        return imageService.deleteImage(images);
    }
    /**
     * 首页推荐图片
     * @return
     */
    @GetMapping("recommend")
    @ApiOperation(value = "获取首页推荐图片",httpMethod = "GET")
    public Result recommendImage(){
       return imageService.recommendImage();
    }

    /**
     * 获取 STS临时权限
     * @return
     */
    @GetMapping("STS")
    @ApiOperation(value = "获取STS临时权限",httpMethod = "GET")
    public Result getSTS(){
        return imageService.getSTS();
    }


    /**
     * 通过图片ID获取详情
     * @param im_id
     * @return
     */
    @GetMapping("info/{im_id}")
    @ApiOperation(value = "通过图片ID获取详情接口",httpMethod = "GET")
    @ApiImplicitParam(name = "im_id",value = "图片ID",dataType = "String",required = true)
    public Result selectImageById(@PathVariable("im_id")String im_id){
        return imageService.selectImageById(im_id);
    }

    /**
     * 通过标签ID查询图片列表接口
     * @param
     * @return
     */
    @PostMapping("la_id")
    @ApiOperation(value = "通过标签ID查询图片列表接口",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "map",value = "imageLabel,pageNum,pageSize,sortType",dataType = "json",required = true)
    })
    public Result selectImageById(@RequestBody Map map){
        return imageService.selectImageByLabel(
                (ImgLabel) map.get("imageLabel"),
                (Integer) map.get("pageNum"),
                (Integer)map.get("pageSize"),
                (Integer)map.get("sortType"));
    }
    /**
     * 通过名称查询图片列表接口
     * @param
     * @return
     */
    @PostMapping("name")
    @ApiOperation(value = "通过名称查询图片列表接口",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "名称",dataType = "String",required = true),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",dataType = "Integer",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页个数",dataType = "Integer",required = true),
            @ApiImplicitParam(name = "sortType",value = "排序类型",dataType = "Integer",required = true)
    })
    public Result selectImageById(@RequestParam("name")String name,
                                  @RequestParam("pageNum")Integer pageNum,
                                  @RequestParam("pageSize")Integer pageSize,
                                  @RequestParam("sortType")Integer sortType){
        return imageService.selectImageByName(name,pageNum,pageSize,sortType);
    }
    /**
     * 通过类别ID查询图片列表接口
     * @param
     * @return
     */
    @PostMapping("t_id")
    @ApiOperation(value = "通过类别ID查询图片列表接口",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "t_id",value = "类别ID",dataType = "Integer",required = true),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",dataType = "Integer",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页个数",dataType = "Integer",required = true),
            @ApiImplicitParam(name = "sortType",value = "排序类型",dataType = "Integer",required = true)
    })
    public Result selectImageById(@RequestParam("t_id")Integer t_id,
                                  @RequestParam("pageNum")Integer pageNum,
                                  @RequestParam("pageSize")Integer pageSize,
                                  @RequestParam("sortType")Integer sortType){
        return imageService.selectImageByType_id(t_id,pageNum,pageSize,sortType);
    }
    @GetMapping("index")
    @ApiOperation(value = "获取首页内容",httpMethod = "GET")
    public Result getIndex(){
        return imageService.getIndex();
    }

}
