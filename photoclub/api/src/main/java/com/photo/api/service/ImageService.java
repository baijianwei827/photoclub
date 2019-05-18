package com.photo.api.service;

import com.photo.api.params.ImageParams;
import com.photo.common.results.Result;
import com.photo.dao.domain.Image;
import com.photo.dao.domain.ImgLabel;
import com.photo.dao.domain.Label;
import com.photo.dao.domain.TypeName;
import javafx.scene.control.Tab;
import java.util.List;

public interface ImageService {
    /**
     * 添加图片
     * @param image
     * @return
     */
    Result insertImage(Image image);

    /**
     * 删除图片
     * @param images
     * @return
     */
    Result deleteImage(Image images);

    /**
     * 修改图片
     * @param image
     * @return
     */
    Result updateImage(Image image);

    /**
     * 通过名称查找图片
     * @param name
     * @param pageNum
     * @param pageSize
     * @param sortType
     * @return
     */
    Result selectImageByName(String name,Integer pageNum,Integer pageSize,Integer sortType);

    /**
     * 通过ID查找
     * @param im_id
     * @return
     */
    Result selectImageById(String im_id);

    /**
     * 通过标签查找
     * @param imgLabel
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result selectImageByLabel(ImgLabel imgLabel, Integer pageNum, Integer pageSize,Integer sortType);

    /**
     * 通过类别名称查找
     * @param t_id
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result selectImageByType_id(Integer t_id,Integer pageNum,Integer pageSize,Integer sortType);

    /**
     * 首页推荐图片
     * @return
     */
    Result recommendImage(ImageParams imageParams);

    /**
     * 获取阿里云临时身份
     * @return
     */
    Result getSTS();

    /**
     * 获取首页的推荐
     * @return
     */
    Result getIndex();

    Result getImgByU_id(ImageParams imageParams);
}
