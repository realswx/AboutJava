package com.qtech.entity;

import java.util.List;



public class PageCompany {
	//当前页数
	static private int currentPageIndex;
	//总页数
	static private int pagerow;
	//每页条数
	static private int pagecount_now=8;
	@Override
	public String toString() {
		return "page [currentPageIndex=" + currentPageIndex + ", pagerow="
				+ pagerow + ", pagecount_now=" + pagecount_now
				+ ", totalDataCount=" + totalDataCount + ", list=" + list + "]";
	}
	//总条数
	static private int totalDataCount;
	//每页的数据
	static private List<Company> list  = null;
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
	public int getPagerow() {
		return pagerow;
	}
	public void setPagerow(int pagerow) {
		this.pagerow = pagerow;
	}
	public int getPagecount_now() {
		return pagecount_now;
	}
	public void setPagecount_now(int pagecount_now) {
		this.pagecount_now = pagecount_now;
	}
	public int getTotalDataCount() {
		return totalDataCount;
	}
	public void setTotalDataCount(int totalDataCount) {
		this.totalDataCount = totalDataCount;
	}
	public List<Company> getList() {
		return list;
	}
	public void setList(List<Company> list) {
		this.list = list;
	}
}
