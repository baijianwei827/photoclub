package com.photo.dao.domain;

import java.util.Date;

public class Love {
    /**
     * 主键 lo_id
     */
    private String lo_id;

    /**
     * 用户ID u_id
     */
    private String u_id;

    /**
     * 图片ID i_id
     */
    private String i_id;

    /**
     * 点赞时间 love_time
     */
    private Date love_time;

    /**
     * 主键
     * @author zw221
     * @return lo_id 主键
     */
    public String getLo_id() {
        return lo_id;
    }

    /**
     * 主键
     * @author zw221
     * @param lo_id 主键
     */
    public void setLo_id(String lo_id) {
        this.lo_id = lo_id == null ? null : lo_id.trim();
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
     * 图片ID
     * @author zw221
     * @return i_id 图片ID
     */
    public String getI_id() {
        return i_id;
    }

    /**
     * 图片ID
     * @author zw221
     * @param i_id 图片ID
     */
    public void setI_id(String i_id) {
        this.i_id = i_id == null ? null : i_id.trim();
    }

    /**
     * 点赞时间
     * @author zw221
     * @return love_time 点赞时间
     */
    public Date getLove_time() {
        return love_time;
    }

    /**
     * 点赞时间
     * @author zw221
     * @param love_time 点赞时间
     */
    public void setLove_time(Date love_time) {
        this.love_time = love_time;
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
        sb.append(", lo_id=").append(lo_id);
        sb.append(", u_id=").append(u_id);
        sb.append(", i_id=").append(i_id);
        sb.append(", love_time=").append(love_time);
        sb.append("]");
        return sb.toString();
    }
}