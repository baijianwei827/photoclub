package com.photo.api.controller;

import com.photo.api.params.ImageParams;
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
     * @param image
     * @return
     */
    @PostMapping("insert")
    @ApiOperation(value = "添加图片",httpMethod = "POST")
    @ApiImplicitParam(name = "Image",value = "图片实体",dataType = "Image",required = true)
    public Result insertImage(@RequestBody Image image){
        return imageService.insertImage(image);
    }

    /**
     * 删除图片
     * @param image
     * @return
     */
    @DeleteMapping("remove")
    @ApiOperation(value = "删除图片",httpMethod = "DELETE")
    @ApiImplicitParam(name = "images",value = "图片列表",dataType = "List<Image>",required = true)
    public Result removeImage(@RequestBody Image image){
        return imageService.deleteImage(image);
    }

    /**
     * 首页推荐图片
     * @return
     */
    @PostMapping("recommend")
    @ApiOperation(value = "获取首页推荐图片",httpMethod = "POST")
    public Result recommendImage(@RequestBody ImageParams imageParams){
       return imageService.recommendImage(imageParams);
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
    public Result selectImageByName(@RequestBody ImageParams imageParams){
        return imageService.selectImageByName(
                imageParams.getIm_title(),
                imageParams.getPageNum(),
                imageParams.getPageSize(),
                imageParams.getSortType());
    }

    /**
     * 通过类别ID查询图片列表接口
     * @param
     * @return
     */
    @PostMapping("t_id")
    @ApiOperation(value = "通过类别ID查询图片列表接口",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ImageParams",value = "ImageParams",dataType = "ImageParams",required = true),
    })
    public Result selectImageById(@RequestBody ImageParams imageParams){
        return imageService.selectImageByType_id(
                imageParams.getT_id(),
                imageParams.getPageNum(),
                imageParams.getPageSize(),
                imageParams.getSortType());
    }

    /**
     * 获取首页内容
     * @return
     */
    @GetMapping("index")
    @ApiOperation(value = "获取首页内容",httpMethod = "GET")
    public Result getIndex(){
        return imageService.getIndex();
    }

    /**
     * 通过用户ID 获取图片列表
     * @param imageParams
     * @return
     */
    @PostMapping("imglist")
    @ApiOperation(value = "用用户ID获取图片列表",httpMethod = "POST")
    public Result getImgListByU_id(@RequestBody ImageParams imageParams){
        return imageService.getImgByU_id(imageParams);
    }

    @PutMapping("update")
    @ApiOperation(value = "修改图片",httpMethod = "PUT")
    public Result updateImage (@RequestBody Image image) {

        return  imageService.updateImage(image);
    }
}
