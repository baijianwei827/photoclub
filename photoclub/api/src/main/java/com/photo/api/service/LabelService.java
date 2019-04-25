package com.photo.api.service;

import com.photo.common.results.Result;
import com.photo.dao.domain.ImgLabel;
import com.photo.dao.domain.Label;

import java.util.Map;

public interface LabelService{

    /**
     * 添加标签
     * @param label
     * @return
     */
    Result insertLabel(ImgLabel label);

    /**
     * 删除标签
     * @param label
     * @return
     */
    Result deleteLabel(ImgLabel label);

    /**
     * 通过用户ID查找用户下的所有标签
     * @param u_id
     * @return
     */
    Result selectImgLabelByU_id(String u_id);

    /**
     * 查找
     * @return
     */
    Result recommendLabel();
}
