package com.photo.dao.repository;

import com.photo.dao.domain.Image;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ImageMapper {
    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int deleteByPrimaryKey(String im_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insert(Image record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int insertSelective(Image record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    Image selectByPrimaryKey(String im_id);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeySelective(Image record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKeyWithBLOBs(Image record);

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    int updateByPrimaryKey(Image record);

    /**
     * 通过标题名称查找
     * @param im_title
     * @param sortType
     * @return
     */
    List<Map> selectImageByName(@Param(value = "im_title")String im_title,@Param("sortType") Integer sortType);

    /**
     *通过专辑ID查找并获取三张图片
     * @param sp_id
     * @return
     */
    @Select("SELECT im_id,im_url FROM t_img WHERE sp_id = #{sp_id} ORDER BY im_time DESC LIMIT 0,3")
    List<Map> selectImgByS_id(@Param(value = "sp_id") String sp_id);

    /**
     * 获取专辑中的图片
     * @param sp_id
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Map> selectImageInfoByS_id(@Param(value = "sp_id") String sp_id,
                                    @Param(value = "pageNum")Integer pageNum,
                                    @Param(value = "pageSize")Integer pageSize);

    /**
     * 获取专辑中图片的总数量
     * @param sp_id
     * @return
     */
    @Select("SELECT COUNT(*) FROM t_img WHERE sp_id = #{sp_id} ORDER BY im_time DESC")
    int selectImageInfoByS_idCount(@Param(value = "sp_id") String sp_id);
    /**
     * 通过图片ID查找图片详情
     * @param im_id
     * @return
     */
    Map selectImageByIm_id(@Param(value = "im_id")String im_id);

    /**
     * 混合查询
     * @param im_title
     * @param is_top
     * @param t_id
     * @param sortType
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Map> recommendImage(@Param(value = "im_title")String im_title,
                             @Param(value = "is_top")Integer is_top,
                             @Param(value = "t_id")Integer t_id,
                             @Param(value = "sortType")Integer sortType,
                             @Param(value = "pageNum") Integer pageNum,
                             @Param(value = "pageSize")Integer pageSize);

    /**
     * 查询个数
     * @param im_title
     * @param is_top
     * @param t_id
     * @param sortType
     * @return
     */
    int recommendImageCount(@Param(value = "im_title")String im_title,
                            @Param(value = "is_top")Integer is_top,
                            @Param(value = "t_id")Integer t_id,
                            @Param(value = "sortType")Integer sortType);
    /**
     * 根据标签ID查找
     * @param l_id
     * @param sortType
     * @return
     */
    List<Map> selectImageByLabel_id(@Param(value = "l_id")String l_id,
                                    @Param(value = "sortType")Integer sortType);

    /**
     * 通过类被ID查找图片
     * @param t_id
     * @param sortType
     * @return
     */
    List<Map> selectImageByT_id(@Param(value = "t_id")Integer t_id,
                                @Param(value = "sortType")Integer sortType);
    /**
     * 通过用户ID查找图片(混合查询)
     * @param u_id
     * @param sortType
     * @return
     */
    List<Map> selectImageByU_id(@Param(value = "u_id")String u_id,
                                @Param("is_cottect")Integer is_cottect,
                                @Param(value = "sortType")Integer sortType,
                                @Param(value = "im_title")String im_title,
                                @Param(value = "pageNum") Integer pageNum,
                                @Param(value = "pageSize")Integer pageSize);

    /**
     * 查询总个数
     * @param u_id
     * @param is_cottect
     * @param sortType
     * @param im_title
     * @return
     */
    int selectImageByU_idCount(@Param(value = "u_id")String u_id,
                                @Param("is_cottect")Integer is_cottect,
                                @Param(value = "sortType")Integer sortType,
                                @Param(value = "im_title")String im_title);
    /**
     *
     * @param number
     * @param sp_id
     * @return
     */
    @Update("UPDATE t_img set love_number = love_number + #{number} WHERE sp_id = #{im_id}")
    int UpdateImgLove(@Param(value = "number") Integer number,
                      @Param(value = "im_id")String sp_id);
}