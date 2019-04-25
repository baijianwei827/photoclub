package com.photo.dao.domain;

public class ImgLabel {
    /**
     * 主键 t_i_la_id
     */
    private String t_i_la_id;

    /**
     * 图片ID i_id
     */
    private String i_id;

    /**
     * 标签ID la_id
     */
    private String la_id;

    /**
     * 标签名称 la_name
     */
    private String la_name;

    /**
     * 主键
     * @author zw221
     * @return t_i_la_id 主键
     */
    public String getT_i_la_id() {
        return t_i_la_id;
    }

    /**
     * 主键
     * @author zw221
     * @param t_i_la_id 主键
     */
    public void setT_i_la_id(String t_i_la_id) {
        this.t_i_la_id = t_i_la_id == null ? null : t_i_la_id.trim();
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
     * 标签ID
     * @author zw221
     * @return la_id 标签ID
     */
    public String getLa_id() {
        return la_id;
    }

    /**
     * 标签ID
     * @author zw221
     * @param la_id 标签ID
     */
    public void setLa_id(String la_id) {
        this.la_id = la_id == null ? null : la_id.trim();
    }

    /**
     * 标签名称
     * @author zw221
     * @return la_name 标签名称
     */
    public String getLa_name() {
        return la_name;
    }

    /**
     * 标签名称
     * @author zw221
     * @param la_name 标签名称
     */
    public void setLa_name(String la_name) {
        this.la_name = la_name == null ? null : la_name.trim();
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
        sb.append(", t_i_la_id=").append(t_i_la_id);
        sb.append(", i_id=").append(i_id);
        sb.append(", la_id=").append(la_id);
        sb.append(", la_name=").append(la_name);
        sb.append("]");
        return sb.toString();
    }
}