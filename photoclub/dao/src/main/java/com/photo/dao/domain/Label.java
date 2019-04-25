package com.photo.dao.domain;

public class Label {
    /**
     * 主键 la_id
     */
    private String la_id;

    /**
     * 标签ID la_name
     */
    private String la_name;

    /**
     * 标签被使用的数量 la_use_number
     */
    private Integer la_use_number;

    /**
     * 主键
     * @author zw221
     * @return la_id 主键
     */
    public String getLa_id() {
        return la_id;
    }

    /**
     * 主键
     * @author zw221
     * @param la_id 主键
     */
    public void setLa_id(String la_id) {
        this.la_id = la_id == null ? null : la_id.trim();
    }

    /**
     * 标签ID
     * @author zw221
     * @return la_name 标签ID
     */
    public String getLa_name() {
        return la_name;
    }

    /**
     * 标签ID
     * @author zw221
     * @param la_name 标签ID
     */
    public void setLa_name(String la_name) {
        this.la_name = la_name == null ? null : la_name.trim();
    }

    /**
     * 标签被使用的数量
     * @author zw221
     * @return la_use_number 标签被使用的数量
     */
    public Integer getLa_use_number() {
        return la_use_number;
    }

    /**
     * 标签被使用的数量
     * @author zw221
     * @param la_use_number 标签被使用的数量
     */
    public void setLa_use_number(Integer la_use_number) {
        this.la_use_number = la_use_number;
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
        sb.append(", la_id=").append(la_id);
        sb.append(", la_name=").append(la_name);
        sb.append(", la_use_number=").append(la_use_number);
        sb.append("]");
        return sb.toString();
    }
}