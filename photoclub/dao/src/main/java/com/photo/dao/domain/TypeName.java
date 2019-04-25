package com.photo.dao.domain;

public class TypeName {
    /**
     * 主键 t_id
     */
    private Integer t_id;

    /**
     * 名称 t_name
     */
    private String t_name;

    /**
     * 主键
     * @author zw221
     * @return t_id 主键
     */
    public Integer getT_id() {
        return t_id;
    }

    /**
     * 主键
     * @author zw221
     * @param t_id 主键
     */
    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    /**
     * 名称
     * @author zw221
     * @return t_name 名称
     */
    public String getT_name() {
        return t_name;
    }

    /**
     * 名称
     * @author zw221
     * @param t_name 名称
     */
    public void setT_name(String t_name) {
        this.t_name = t_name == null ? null : t_name.trim();
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
        sb.append(", t_id=").append(t_id);
        sb.append(", t_name=").append(t_name);
        sb.append("]");
        return sb.toString();
    }
}