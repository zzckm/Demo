package com.zhiyou100.util;

/**
 * @Author:段晨曦
 * @Date: 2019/2/25 10:21
 */
public class PageDivide {
    //首页
    int start;
    //尾页
    int end;
    //当前页
    int now;
    //每页的记录数
    int pageSize;
    //总记录数
    int total;


    public PageDivide() {
    }

    public PageDivide(int end, int now, int pageSize, int total) {
        this.end = end;
        this.now = now;
        this.pageSize = pageSize;
        this.total = total;
    }

    public PageDivide(int start, int end, int now, int pageSize, int total) {
        this.start = start;
        this.end = end;
        this.now = now;
        this.pageSize = pageSize;
        this.total = total;
    }
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
