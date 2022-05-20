package com.test.pojo;

import java.util.List;

public class PageBean<T> {
    private int totalCount;
    private List<T> rows;
    /**
     * @return the totalCount
     */
    public int gettotalCount() {
        return totalCount;
    }
    /**
     * @param totalCount the totalCount to set
     */
    public void settotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    /**
     * @return the rows
     */
    public List<T> getRows() {
        return rows;
    }
    /**
     * @param rows the rows to set
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
