package com.photo.dao.repository;

import com.photo.dao.domain.Image;
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
     *通过专辑ID查找
     * @param sp_id
     * @return
     */
    @Select("SELECT im_id,im_url FROM t_img WHERE sp_id = #{sp_id} ORDER BY im_time DESC LIMIT 0,3")
    List<Map> selectImgByS_id(@Param(value = "sp_id") String sp_id);

    /**
     * 通过图片ID查找图片详情
     * @param im_id
     * @return
     */
    Map selectImageByIm_id(@Param(value = "im_id")String im_id);
    @Select("SELECT * FROM t_img WHERE is_top=#{is_top} ORDER BY top_time DESC ")
    List<Map> recommendImage(@Param("is_top")Integer is_top);
    /**
     * 根据标签ID查找
     * @param l_id
     * @param sortType
     * @return
     */
    List<Map> selectImageByLabel_id(@Param(value = "l_id")String l_id,@Param(value = "sortType")Integer sortType);

    /**
     * 通过类被ID查找图片
     * @param l_id
     * @param sortType
     * @return
     */
    List<Map> selectImageByT_id(@Param(value = "t_id")Integer l_id,@Param(value = "sortType")Integer sortType);
    /**
     *
     * @param number
     * @param sp_id
     * @return
     */
    @Update("UPDATE t_img set love_number = love_number + #{number} WHERE sp_id = #{im_id}")
    int UpdateImgLove(@Param(value = "number") Integer number,@Param(value = "im_id")String sp_id);
}