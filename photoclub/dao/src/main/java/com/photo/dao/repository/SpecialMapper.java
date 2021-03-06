package com.photo.dao.repository;

import com.photo.dao.domain.Special;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface SpecialMapper {
    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int deleteByPrimaryKey(String sp_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insert(Special record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insertSelective(Special record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    Special selectByPrimaryKey(String sp_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeySelective(Special record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeyWithBLOBs(Special record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKey(Special record);

    /**
     * 通过用户ID查找专辑
     * @param u_id
     * @return
     */
    List<Map> selectSpecialByU_id(@Param(value = "u_id") String u_id,
                                  @Param("sp_name")String sp_name,
                                  @Param(value = "sortType") Integer sortType,
                                  @Param(value = "pageNum") Integer pageNum,
                                  @Param(value = "pageSize") Integer pageSize);

    int selectSpecialByU_idCount(@Param(value = "u_id") String u_id,
                                 @Param("sp_name")String sp_name,
                                 @Param(value = "sortType") Integer sortType);

    /**
     * 通过类别、名称查询
     * @param t_id
     * @param sp_name
     * @return
     */
    List<Map> selectSpecialByT_idAndName(@Param(value = "t_id") Integer t_id,
                                         @Param(value = "sp_name")String sp_name,
                                         @Param(value = "sortType")Integer sortType,
                                         @Param(value = "pageNum")Integer pageNum,
                                         @Param(value = "pageSize")Integer pageSize);

    /***
     *
     * @param t_id
     * @param sp_name
     * @param sortType
     * @return
     */
    int selectSpecialByT_idAndNameCount(@Param(value = "t_id") Integer t_id,
                                        @Param(value = "sp_name")String sp_name,
                                        @Param(value = "sortType")Integer sortType);

    /**
     * 通过专辑ID查找专辑
     * @param s_id
     * @return
     */
    Map selectSpecialByS_id(@Param(value = "s_id") String s_id);

    /**
     * 关注个数的加减
     * @param number
     * @return
     */
    @Update("UPDATE t_special set attention_number = attention_number + #{number} WHERE sp_id = #{sp_id}")
    int UpdateSpecialAttention(@Param(value = "number") Integer number,@Param(value = "sp_id")String sp_id);

    /**
     * 更改评论数
     * @param number
     * @param sp_id
     * @return
     */
    @Update("UPDATE t_special set comment_number = comment_number + #{number} WHERE sp_id = #{sp_id}")
    int UpdateSpecialComment(@Param(value = "number") Integer number,@Param(value = "sp_id")String sp_id);

    @Update("UPDATE t_special set i_number = i_number + #{number} WHERE sp_id = #{sp_id}")
    int UpdateSpecialImgNumber(@Param(value = "number") Integer number,@Param(value = "sp_id")String sp_id);

    /**
     * 查询置顶的specail
     * @param is_top
     * @return
     */
    List<Map> selectSpecialRecommend(@Param("is_top")Integer is_top);

    /**
     * 获取用户所有专辑
     * @param u_id
     * @return
     */
    @Select("SELECT sp_id,sp_name,t_id FROM t_special WHERE u_id=#{u_id}")
    List<Map> selectAllSpecialByU_id(@Param("u_id") String u_id);



}