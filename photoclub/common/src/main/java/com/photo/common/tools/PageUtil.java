package com.photo.common.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtil<T> {
    // 以下4个属性必须指定
    private List<T> records; // 分页数据
    private int totalRecord; // 总记录数
    private int pageNo; // 当前页码,第几页
    private int pageSize; // 每页显示的记录数,每页显示多少条数据
    private int totalPage; // 总页数

    private int startIndex; // 开始索引
    private int endIndex; // 结束索引

    private int indexCount = 10;// 显示的索引数目,如:10的话， 则显示1-10， 2-11

    // 前端传进来的字段
    public PageUtil(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        if (pageNo <= 0)
            pageNo = 1;
        if (pageSize <= 0)
            pageSize = this.indexCount;
        // 计算开始位置和结束位置
        int n = pageNo == 1 ? this.startIndex = 0 : (this.startIndex = (pageNo - 1) * pageSize);
        this.endIndex = this.startIndex + pageSize;
    }

    public void setList(List<T> records, int totalRecord) {
        this.records = records;
        this.totalRecord = totalRecord;
        // 计算总页数
        int totalPages = this.totalRecord / this.pageSize;
        this.totalPage = (this.totalRecord % pageSize == 0) ? totalPages: (totalPages + 1);
    }
    public Map getList() {
        Map map = new HashMap();
        map.put("pageNum", this.pageNo);
        map.put("pageSize", this.pageSize);
        map.put("pages", this.totalPage);
        map.put("total", this.totalRecord);
        map.put("list", this.records);
        return map;
    }
    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getIndexCount() {
        return indexCount;
    }

    public void setIndexCount(int indexCount) {
        this.indexCount = indexCount;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "records=" + records +
                ", totalRecord=" + totalRecord +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", indexCount=" + indexCount +
                '}';
    }

}
