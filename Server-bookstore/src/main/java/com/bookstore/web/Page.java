package com.bookstore.web;

import java.util.List;

public class Page<T> {
    private int pageNo;
    private List<T> list;
    private int pageSize = 3;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    private long totalItemCount;

    public long getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(long totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public Page(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageCount() {
        int count = (int) this.totalItemCount / this.pageSize;
        if (this.totalItemCount % this.pageSize != 0) {
            count++;
        }
        return count;
    }

    public int getPageNo() {
        if (pageNo > getPageCount()) {
            pageNo = getPageCount();
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
        return pageNo;
    }

    public boolean isHasNextPage() {
        if (getPageNo() < getPageCount()) {
            return true;
        }
        return false;
    }

    public boolean isHasPrevPage() {
        if (getPageNo() > 1) {
            return true;
        }
        return false;
    }

    public int getNextPageNo() {
        if (isHasNextPage()) {
            return getPageNo() + 1;
        }
        return getPageNo();
    }

    public int getPrevPageNo() {
        if (isHasPrevPage()) {
            return getPageNo() - 1;
        }
        return getPageNo();
    }
}
