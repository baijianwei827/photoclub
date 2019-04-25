package com.photo.dao.domain;

import java.util.Date;

public class Attention {
    /**
     * 主键 a_id
     */
    private String a_id;

    /**
     * 关注人ID u_id
     */
    private String u_id;

    /**
     * 被关注ID by_u_id
     */
    private String by_u_id;

    /**
     * 0:人，1:专辑 a_type
     */
    private Integer a_type;
    /**
     * 关注时间 a_time
     */
    private Date a_time;

    /**
     * 主键
     * @author zw221
     * @return a_id 主键
     */
    public String getA_id() {
        return a_id;
    }

    /**
     * 主键
     * @author zw221
     * @param a_id 主键
     */
    public void setA_id(String a_id) {
        this.a_id = a_id == null ? null : a_id.trim();
    }

    /**
     * 关注人ID
     * @author zw221
     * @return u_id 关注人ID
     */
    public String getU_id() {
        return u_id;
    }

    /**
     * 关注人ID
     * @author zw221
     * @param u_id 关注人ID
     */
    public void setU_id(String u_id) {
        this.u_id = u_id == null ? null : u_id.trim();
    }

    /**
     * 被关注ID
     * @author zw221
     * @return by_u_id 被关注ID
     */
    public String getBy_u_id() {
        return by_u_id;
    }

    /**
     * 被关注ID
     * @author zw221
     * @param by_u_id 被关注ID
     */
    public void setBy_u_id(String by_u_id) {
        this.by_u_id = by_u_id == null ? null : by_u_id.trim();
    }

    /**
     * 0:人，1:专辑
     * @author zw221
     * @return a_type 0:人，1:专辑
     */
    public Integer getA_type() {
        return a_type;
    }

    /**
     * 0:人，1:专辑
     * @author zw221
     * @param a_type 0:人，1:专辑
     */
    public void setA_type(Integer a_type) {
        this.a_type = a_type; }
    /**
     * 关注时间
     * @author zw221
     * @return a_time 关注时间
     */
    public Date getA_time() {
        return a_time;
    }

    /**
     * 关注时间
     * @author zw221
     * @param a_time 关注时间
     */
    public void setA_time(Date a_time) {
        this.a_time = a_time;
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
        sb.append(", a_id=").append(a_id);
        sb.append(", u_id=").append(u_id);
        sb.append(", by_u_id=").append(by_u_id);
        sb.append(", a_type=").append(a_type);
        sb.append(", a_time=").append(a_time);
        sb.append("]");
        return sb.toString();
    }
}