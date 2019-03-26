package com.zhiyou100.util;

public class Pager {
	
    int total;//总数据条数
    int pageNo;//当前页
    int pageSize;//页面数据条数
    int pageCount;//总页面数
    int start;//首页
    int end;//尾页
    
    // 注意：构建函数重载与this的使用
    public Pager(int total, int pageNo) {
    	this(total, pageNo, 10);
    }
    
    public Pager(int total, int pageNo, int pageSize) {
        this.total = total;
        this.pageNo = pageNo;
        this.start = pageNo;
        this.end = pageNo;
        this.pageSize = pageSize;

        this.pageCount = (int)Math.ceil(this.total * 1.0 / this.pageSize);

        int count = 1;

        while (count < 7 && (this.start > 1 || this.end < this.pageCount)) {
            if (this.start > 1) {
                this.start--;
                count++;
            }
            if (this.end < this.pageCount) {
                this.end++;
                count++;
            }
        }
    }
    
    @Override
    public String toString() {
    	return "{" +
				"total:" + this.total + ", " +
				"pageNo:" + this.pageNo + ", " +
				"pageSize:" + this.pageSize + ", " +
				"pageCount:" + this.pageCount + ", " + 
				"start:" + this.start + ", " +
				"end:" + this.end + ", " +
				"}";
    }

    public int getTotal() {
        return this.total;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
    
}
