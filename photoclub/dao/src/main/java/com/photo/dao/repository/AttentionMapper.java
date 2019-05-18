package com.photo.dao.repository;

import com.photo.dao.domain.Attention;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface AttentionMapper {
    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int deleteByPrimaryKey(String a_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insert(Attention record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insertSelective(Attention record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    Attention selectByPrimaryKey(String a_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeySelective(Attention record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKey(Attention record);

    /**
     * 取消关注或删除粉丝
     * @param u_id
     * @param by_u_id
     * @return
     */
    @Delete("DELETE FROM t_attention WHERE u_id =#{u_id} AND by_u_id =#{by_u_id}")
    int removeAttentionOrBean(@Param(value = "u_id")String u_id,@Param(value = "by_u_id")String by_u_id);

    /**
     * 查找用户下所有关注
     * @return
     */

    List<Map> selectAttentionByU_id(@Param(value = "u_id") String u_id,@Param(value = "a_type")Integer a_type);

    /**
     * 查找具体一个关注
     * @param u_id
     * @param by_u_id
     * @return
     */
    Map selectAttentionByU_idBy_id(@Param(value = "u_id") String u_id,@Param(value = "by_u_id") String by_u_id);

    /**
     * 判断某个关注是否存在
     * @param u_id
     * @param by_u_id
     * @return
     */
    @Select("SELECT * FROM t_attention WHERE u_id = #{u_id} AND by_u_id = #{by_u_id} AND a_type = #{a_type}")
    Map selectIsAttention(@Param(value = "u_id") String u_id,
                          @Param(value = "by_u_id") String by_u_id,
                          @Param(value = "a_type")Integer a_type);
    /**
     * 查找粉丝
     * @param u_id
     * @return
     */
    List<Map> selectBeanByU_id(@Param(value = "u_id") String u_id);

    /**
     * 查找关注的专辑
     * @param u_id
     * @return
     */
    @Select("SELECT * FROM t_attention a ,t_user u,t_special sp WHERE u.u_id = a.u_id AND a.by_u_id = sp.sp_id AND a.u_id =#{u_id}")
    List<Map> selectAttentionSpecialBySe_id(@Param(value = "u_id") String u_id);

}