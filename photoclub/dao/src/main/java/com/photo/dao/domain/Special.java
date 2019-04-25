package com.photo.dao.domain;

import java.util.Date;

public class Special {
    /**
     * 主键 sp_id
     */
    private String sp_id;

    /**
     * 用户ID(外键) u_id
     */
    private String u_id;

    /**
     * 类别ID t_id
     */
    private Integer t_id;

    /**
     * 专辑名称 sp_name
     */
    private String sp_name;

    /**
     * 图片数量 i_number
     */
    private Integer i_number;

    /**
     * 封面 img_cover
     */
    private String img_cover;

    /**
     * 创建时间 sp_time
     */
    private Date sp_time;

    /**
     * 专辑描述 sp_describe
     */
    private String sp_describe;

    /**
     * 主键
     * @author zw221
     * @return sp_id 主键
     */
    public String getSp_id() {
        return sp_id;
    }

    /**
     * 主键
     * @author zw221
     * @param sp_id 主键
     */
    public void setSp_id(String sp_id) {
        this.sp_id = sp_id == null ? null : sp_id.trim();
    }

    /**
     * 用户ID(外键)
     * @author zw221
     * @return u_id 用户ID(外键)
     */
    public String getU_id() {
        return u_id;
    }

    /**
     * 用户ID(外键)
     * @author zw221
     * @param u_id 用户ID(外键)
     */
    public void setU_id(String u_id) {
        this.u_id = u_id == null ? null : u_id.trim();
    }

    /**
     * 类别ID
     * @author zw221
     * @return t_id 类别ID
     */
    public Integer getT_id() {
        return t_id;
    }

    /**
     * 类别ID
     * @author zw221
     * @param t_id 类别ID
     */
    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    /**
     * 专辑名称
     * @author zw221
     * @return sp_name 专辑名称
     */
    public String getSp_name() {
        return sp_name;
    }

    /**
     * 专辑名称
     * @author zw221
     * @param sp_name 专辑名称
     */
    public void setSp_name(String sp_name) {
        this.sp_name = sp_name == null ? null : sp_name.trim();
    }

    /**
     * 图片数量
     * @author zw221
     * @return i_number 图片数量
     */
    public Integer getI_number() {
        return i_number;
    }

    /**
     * 图片数量
     * @author zw221
     * @param i_number 图片数量
     */
    public void setI_number(Integer i_number) {
        this.i_number = i_number;
    }

    /**
     * 封面
     * @author zw221
     * @return img_cover 封面
     */
    public String getImg_cover() {
        return img_cover;
    }

    /**
     * 封面
     * @author zw221
     * @param img_cover 封面
     */
    public void setImg_cover(String img_cover) {
        this.img_cover = img_cover == null ? null : img_cover.trim();
    }

    /**
     * 创建时间
     * @author zw221
     * @return sp_time 创建时间
     */
    public Date getSp_time() {
        return sp_time;
    }

    /**
     * 创建时间
     * @author zw221
     * @param sp_time 创建时间
     */
    public void setSp_time(Date sp_time) {
        this.sp_time = sp_time;
    }

    /**
     * 专辑描述
     * @author zw221
     * @return sp_describe 专辑描述
     */
    public String getSp_describe() {
        return sp_describe;
    }

    /**
     * 专辑描述
     * @author zw221
     * @param sp_describe 专辑描述
     */
    public void setSp_describe(String sp_describe) {
        this.sp_describe = sp_describe == null ? null : sp_describe.trim();
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
        sb.append(", sp_id=").append(sp_id);
        sb.append(", u_id=").append(u_id);
        sb.append(", t_id=").append(t_id);
        sb.append(", sp_name=").append(sp_name);
        sb.append(", i_number=").append(i_number);
        sb.append(", img_cover=").append(img_cover);
        sb.append(", sp_time=").append(sp_time);
        sb.append(", sp_describe=").append(sp_describe);
        sb.append("]");
        return sb.toString();
    }
}