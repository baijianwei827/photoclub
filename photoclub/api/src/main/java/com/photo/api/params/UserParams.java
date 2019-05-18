package com.photo.api.params;

public class UserParams {
    private String u_id;
    private String u_nickName;
    private Integer pageNum;
    private Integer pageSize;
    private Integer sortType;

    public UserParams(String u_id, String u_nickName, Integer pageNum, Integer pageSize) {
        this.u_id = u_id;
        this.u_nickName = u_nickName;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public UserParams() {
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_nickName() {
        return u_nickName;
    }

    public void setU_nickName(String u_nickName) {
        this.u_nickName = u_nickName;
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

    @Override
    public String toString() {
        return "UserParams{" +
                "u_id='" + u_id + '\'' +
                ", u_nickName='" + u_nickName + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", sortType=" + sortType +
                '}';
    }
}
