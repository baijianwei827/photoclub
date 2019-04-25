package com.photo.dao.repository;

import com.photo.dao.domain.Label;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface LabelMapper {
    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int deleteByPrimaryKey(String la_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insert(Label record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insertSelective(Label record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    Label selectByPrimaryKey(String la_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeySelective(Label record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKey(Label record);

    /**
     * 通过名称查找标签
     * @param name
     * @return
     */
    @Select("SELECT * FROM t_label WHERE la_name=#{la_name}")
    Label selectLabelByName(@Param("la_name") String name);

    /**
     * 查找首页标签
     * @param is_top
     * @return
     */
    @Select("SELECT * FROM t_label WHERE is_top = #{is_top} ORDER BY top_time DESC")
    List<Map> recommendLabel(@Param("is_top")Integer is_top);
}