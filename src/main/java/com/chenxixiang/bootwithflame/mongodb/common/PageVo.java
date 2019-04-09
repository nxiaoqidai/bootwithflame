package com.chenxixiang.bootwithflame.mongodb.common;

import java.util.List;

public class PageVo<T> {
	private int pageIndex;
	private int pageSize;
	private long total;
	private List<T> pageData;

	public PageVo() {

	}

	public PageVo(int pageIndex, int pageSize, long total, List<T> pageData) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.total = total;
		this.pageData = pageData;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

}
