package com.photo.dao.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Image {
    /**
     * 主键 im_id
     */
    private String im_id;

    /**
     * 专辑ID sp_id
     */
    private String sp_id;

    /**
     * 用户ID u_id
     */
    private String u_id;

    /**
     * 是否为收藏:0:收藏，1:为上传 is_cottect
     */
    private Integer is_cottect;

    /**
     * 图片ID t_id
     */
    private Integer t_id;

    /**
     * 图片地址 im_url
     */
    private String im_url;

    /**
     * 创建时间 im_time
     */
    private Date im_time;

    /**
     * 来源专辑ID im_source
     */
    private String im_source;

    /**
     * 来源于用户ID im_source_uId
     */
    private String im_source_uId;

    /**
     * 来源于用户名称 im_source_name
     */
    private String im_source_name;

    /**
     * 点赞个数 love_number
     */
    private Integer love_number;

    /**
     * 评论个数 comment_nummber
     */
    private Integer comment_nummber;

    /**
     * 图片描述 im_troduce
     */
    private String im_troduce;
    /**
     * 图片标题
     */
    private String im_title;
    /**
     * 是否置顶
     */
    private Integer is_top;
    /**
     * 置顶时间
     */
    private Timestamp top_time;
    /**
     * 标签列表
     */
    private List<ImgLabel> imgLabels;


    public List<ImgLabel> getImgLabels() {
        return imgLabels;
    }

    public void setImgLabels(List<ImgLabel> imgLabels) {
        this.imgLabels = imgLabels;
    }

    /**
     * 主键
     * @author zw221
     * @return im_id 主键
     */
    public String getIm_id() {
        return im_id;
    }

    /**
     * 主键
     * @author zw221
     * @param im_id 主键
     */
    public void setIm_id(String im_id) {
        this.im_id = im_id == null ? null : im_id.trim();
    }

    /**
     * 专辑ID
     * @author zw221
     * @return sp_id 专辑ID
     */
    public String getSp_id() {
        return sp_id;
    }

    /**
     * 专辑ID
     * @author zw221
     * @param sp_id 专辑ID
     */
    public void setSp_id(String sp_id) {
        this.sp_id = sp_id == null ? null : sp_id.trim();
    }

    /**
     * 用户ID
     * @author zw221
     * @return u_id 用户ID
     */
    public String getU_id() {
        return u_id;
    }

    /**
     * 用户ID
     * @author zw221
     * @param u_id 用户ID
     */
    public void setU_id(String u_id) {
        this.u_id = u_id == null ? null : u_id.trim();
    }

    public String getIm_title() {
        return im_title;
    }

    public void setIm_title(String im_title) {
        this.im_title = im_title;
    }

    /**
     * 是否为收藏:0:收藏，1:为上传
     * @author zw221
     * @return is_cottect 是否为收藏:0:收藏，1:为上传
     */
    public Integer getIs_cottect() {
        return is_cottect;
    }

    /**
     * 是否为收藏:0:收藏，1:为上传
     * @author zw221
     * @param is_cottect 是否为收藏:0:收藏，1:为上传
     */
    public void setIs_cottect(Integer is_cottect) {
        this.is_cottect = is_cottect;
    }

    /**
     * 图片ID
     * @author zw221
     * @return t_id 图片ID
     */
    public Integer getT_id() {
        return t_id;
    }

    /**
     * 图片ID
     * @author zw221
     * @param t_id 图片ID
     */
    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    /**
     * 图片地址
     * @author zw221
     * @return im_url 图片地址
     */
    public String getIm_url() {
        return im_url;
    }

    /**
     * 图片地址
     * @author zw221
     * @param im_url 图片地址
     */
    public void setIm_url(String im_url) {
        this.im_url = im_url == null ? null : im_url.trim();
    }

    /**
     * 创建时间
     * @author zw221
     * @return im_time 创建时间
     */
    public Date getIm_time() {
        return im_time;
    }

    /**
     * 创建时间
     * @author zw221
     * @param im_time 创建时间
     */
    public void setIm_time(Date im_time) {
        this.im_time = im_time;
    }

    /**
     * 来源专辑ID
     * @author zw221
     * @return im_source 来源专辑ID
     */
    public String getIm_source() {
        return im_source;
    }

    /**
     * 来源专辑ID
     * @author zw221
     * @param im_source 来源专辑ID
     */
    public void setIm_source(String im_source) {
        this.im_source = im_source == null ? null : im_source.trim();
    }

    /**
     * 来源于用户ID
     * @author zw221
     * @return im_source_uId 来源于用户ID
     */
    public String getIm_source_uId() {
        return im_source_uId;
    }

    /**
     * 来源于用户ID
     * @author zw221
     * @param im_source_uId 来源于用户ID
     */
    public void setIm_source_uId(String im_source_uId) {
        this.im_source_uId = im_source_uId == null ? null : im_source_uId.trim();
    }

    /**
     * 来源于用户名称
     * @author zw221
     * @return im_source_name 来源于用户名称
     */
    public String getIm_source_name() {
        return im_source_name;
    }

    /**
     * 来源于用户名称
     * @author zw221
     * @param im_source_name 来源于用户名称
     */
    public void setIm_source_name(String im_source_name) {
        this.im_source_name = im_source_name == null ? null : im_source_name.trim();
    }

    /**
     * 点赞个数
     * @author zw221
     * @return love_number 点赞个数
     */
    public Integer getLove_number() {
        return love_number;
    }

    /**
     * 点赞个数
     * @author zw221
     * @param love_number 点赞个数
     */
    public void setLove_number(Integer love_number) {
        this.love_number = love_number;
    }

    /**
     * 评论个数
     * @author zw221
     * @return comment_nummber 评论个数
     */
    public Integer getComment_nummber() {
        return comment_nummber;
    }

    /**
     * 评论个数
     * @author zw221
     * @param comment_nummber 评论个数
     */
    public void setComment_nummber(Integer comment_nummber) {
        this.comment_nummber = comment_nummber;
    }

    /**
     * 图片描述
     * @author zw221
     * @return im_troduce 图片描述
     */
    public String getIm_troduce() {
        return im_troduce;
    }

    /**
     * 图片描述
     * @author zw221
     * @param im_troduce 图片描述
     */
    public void setIm_troduce(String im_troduce) {
        this.im_troduce = im_troduce == null ? null : im_troduce.trim();
    }

    public Integer getIs_top() {
        return is_top;
    }

    public void setIs_top(Integer is_top) {
        this.is_top = is_top;
    }

    public Timestamp getTop_time() {
        return top_time;
    }

    public void setTop_time(Timestamp top_time) {
        this.top_time = top_time;
    }

    /**
     *
     * @mbg.generated 2019-04-15 11:25:05
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", im_id=").append(im_id);
        sb.append(", sp_id=").append(sp_id);
        sb.append(", u_id=").append(u_id);
        sb.append(", is_cottect=").append(is_cottect);
        sb.append(", t_id=").append(t_id);
        sb.append(", im_url=").append(im_url);
        sb.append(", im_time=").append(im_time);
        sb.append(", im_source=").append(im_source);
        sb.append(", im_source_uId=").append(im_source_uId);
        sb.append(", im_source_name=").append(im_source_name);
        sb.append(", love_number=").append(love_number);
        sb.append(", comment_nummber=").append(comment_nummber);
        sb.append(", im_troduce=").append(im_troduce);
        sb.append("]");
        return sb.toString();
    }
}