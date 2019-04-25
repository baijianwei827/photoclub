package com.photo.dao.paramVo;

import com.photo.dao.domain.Special;

public class SpecialParamVo extends Special {
    /**
     * 开始页
     */
    private Integer pageNum;
    /**
     * 每页个数
     */
    private Integer pageSize;

    public SpecialParamVo(Integer pageNum ,Integer pageSize){
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
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
        return "SpecialParamVo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
