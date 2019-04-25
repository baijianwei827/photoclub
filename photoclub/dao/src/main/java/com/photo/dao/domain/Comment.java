package com.photo.dao.domain;

import java.util.Date;

public class Comment {
    /**
     * 主键 co_id
     */
    private String co_id;

    /**
     * 专辑ID sp_id
     */
    private String sp_id;

    /**
     * 用户ID u_id
     */
    private String u_id;

    /**
     * 用户昵称 u_nickName
     */
    private String u_nickName;

    /**
     * 用户头像 u_avatar
     */
    private String u_avatar;

    /**
     * 评论内容 content
     */
    private String content;

    /**
     * 评论类型：0:不回复，1:回复 co_type
     */
    private Integer co_type;

    /**
     * 回复人ID an_id
     */
    private String an_id;

    /**
     * 回复人昵称 an_name
     */
    private String an_name;

    /**
     * 创建时间 co_time
     */
    private Date co_time;

    /**
     * 主键
     * @author zw221
     * @return co_id 主键
     */
    public String getCo_id() {
        return co_id;
    }

    /**
     * 主键
     * @author zw221
     * @param co_id 主键
     */
    public void setCo_id(String co_id) {
        this.co_id = co_id == null ? null : co_id.trim();
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

    /**
     * 用户昵称
     * @author zw221
     * @return u_nickName 用户昵称
     */
    public String getU_nickName() {
        return u_nickName;
    }

    /**
     * 用户昵称
     * @author zw221
     * @param u_nickName 用户昵称
     */
    public void setU_nickName(String u_nickName) {
        this.u_nickName = u_nickName == null ? null : u_nickName.trim();
    }

    /**
     * 用户头像
     * @author zw221
     * @return u_avatar 用户头像
     */
    public String getU_avatar() {
        return u_avatar;
    }

    /**
     * 用户头像
     * @author zw221
     * @param u_avatar 用户头像
     */
    public void setU_avatar(String u_avatar) {
        this.u_avatar = u_avatar == null ? null : u_avatar.trim();
    }

    /**
     * 评论内容
     * @author zw221
     * @return content 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 评论内容
     * @author zw221
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 评论类型：0:不回复，1:回复
     * @author zw221
     * @return co_type 评论类型：0:不回复，1:回复
     */
    public Integer getCo_type() {
        return co_type;
    }

    /**
     * 评论类型：0:不回复，1:回复
     * @author zw221
     * @param co_type 评论类型：0:不回复，1:回复
     */
    public void setCo_type(Integer co_type) {
        this.co_type = co_type;
    }

    /**
     * 回复人ID
     * @author zw221
     * @return an_id 回复人ID
     */
    public String getAn_id() {
        return an_id;
    }

    /**
     * 回复人ID
     * @author zw221
     * @param an_id 回复人ID
     */
    public void setAn_id(String an_id) {
        this.an_id = an_id == null ? null : an_id.trim();
    }

    /**
     * 回复人昵称
     * @author zw221
     * @return an_name 回复人昵称
     */
    public String getAn_name() {
        return an_name;
    }

    /**
     * 回复人昵称
     * @author zw221
     * @param an_name 回复人昵称
     */
    public void setAn_name(String an_name) {
        this.an_name = an_name == null ? null : an_name.trim();
    }

    /**
     * 创建时间
     * @author zw221
     * @return co_time 创建时间
     */
    public Date getCo_time() {
        return co_time;
    }

    /**
     * 创建时间
     * @author zw221
     * @param co_time 创建时间
     */
    public void setCo_time(Date co_time) {
        this.co_time = co_time;
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
        sb.append(", co_id=").append(co_id);
        sb.append(", sp_id=").append(sp_id);
        sb.append(", u_id=").append(u_id);
        sb.append(", u_nickName=").append(u_nickName);
        sb.append(", u_avatar=").append(u_avatar);
        sb.append(", content=").append(content);
        sb.append(", co_type=").append(co_type);
        sb.append(", an_id=").append(an_id);
        sb.append(", an_name=").append(an_name);
        sb.append(", co_time=").append(co_time);
        sb.append("]");
        return sb.toString();
    }
}