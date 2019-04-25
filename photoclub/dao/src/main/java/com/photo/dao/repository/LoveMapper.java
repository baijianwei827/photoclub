package com.photo.dao.repository;

import com.photo.dao.domain.Love;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface LoveMapper {
    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int deleteByPrimaryKey(String lo_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insert(Love record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insertSelective(Love record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    Love selectByPrimaryKey(String lo_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeySelective(Love record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKey(Love record);

    /**
     * 通过用户ID和图片ID查询
     * @param u_id
     * @param i_id
     * @return
     */
    @Select("SELECT * FROM t_love WHERE u_id=#{u_id} AND i_id=#{i_id}")
    Map selectLoveByI_idAndU_id(String u_id ,String i_id);

    /**
     * 取消点赞
     * @param u_id
     * @param i_id
     * @return
     */
    @Delete("DELETE FROM t_love WHERE u_id=#{u_id} AND i_id=#{i_id}")
    int removeLove(String u_id ,String i_id);


}