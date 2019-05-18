package com.photo.api.params;

public class SpecialParams {

    private String u_id;
    private String sp_id;
    private String sp_name;
    private Integer t_id;
    private Integer pageNum;
    private Integer pageSize;
    private Integer sortType;

    public SpecialParams() {
    }

    public SpecialParams(String u_id, String sp_id, Integer t_id, Integer pageNum, Integer pageSize, Integer sortType) {
        this.u_id = u_id;
        this.sp_id = sp_id;
        this.t_id = t_id;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.sortType = sortType;
    }

    public String getSp_name() {
        return sp_name;
    }

    public void setSp_name(String sp_name) {
        this.sp_name = sp_name;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getSp_id() {
        return sp_id;
    }

    public void setSp_id(String sp_id) {
        this.sp_id = sp_id;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    @Override
    public String toString() {
        return "SpecialParams{" +
                "u_id='" + u_id + '\'' +
                ", sp_id='" + sp_id + '\'' +
                ", t_id=" + t_id +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", sortType=" + sortType +
                '}';
    }
}
