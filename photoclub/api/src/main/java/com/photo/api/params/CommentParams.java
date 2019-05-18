package com.photo.api.params;

public class CommentParams {
    private String sp_id;
    private Integer pageNum;
    private Integer pageSize;

    public CommentParams() {
    }

    public CommentParams(String sp_id, Integer pageNum, Integer pageSize) {
        this.sp_id = sp_id;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getSp_id() {
        return sp_id;
    }

    public void setSp_id(String sp_id) {
        this.sp_id = sp_id;
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
        return "CommentParams{" +
                "sp_id='" + sp_id + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
