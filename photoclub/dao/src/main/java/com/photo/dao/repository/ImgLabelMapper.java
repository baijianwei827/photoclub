package com.photo.dao.repository;

import com.photo.dao.domain.ImgLabel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ImgLabelMapper {
    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int deleteByPrimaryKey(String t_i_la_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insert(ImgLabel record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insertSelective(ImgLabel record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    ImgLabel selectByPrimaryKey(String t_i_la_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeySelective(ImgLabel record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKey(ImgLabel record);

    /**
     * 获取图片标签
     * @param im_id
     * @return
     */
    @Select("Select * FROM t_img_label WHERE im_id =#{im_id}")
    List<Map> selectImgLabel(@Param(value = "im_id") String im_id);

    /**
     * 通过用户ID查找用户下所有标签
     * @param u_id
     * @return
     */
    @Select("SELECT * FROM t_img_label WHERE u_id = #{u_id}")
    List<Map> selectImgLabelByU_id(@Param("u_id")String u_id);
}