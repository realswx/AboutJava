package com.qtech.entity;

public class Company {
	int c_id;
	String c_name;
	String c_area;
	String c_size;
	String c_type;
	String c_brief;
	int c_state;
	int c_sort;
	int c_viewnum;
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getC_viewnum() {
		return c_viewnum;
	}
	public void setC_viewnum(int c_viewnum) {
		this.c_viewnum = c_viewnum;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_area() {
		return c_area;
	}
	public void setC_area(String c_area) {
		this.c_area = c_area;
	}
	public String getC_size() {
		return c_size;
	}
	public void setC_size(String c_size) {
		this.c_size = c_size;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	public String getC_brief() {
		return c_brief;
	}
	public void setC_brief(String c_brief) {
		this.c_brief = c_brief;
	}
	public int getC_state() {
		return c_state;
	}
	public void setC_state(int c_state) {
		this.c_state = c_state;
	}
	public int getC_sort() {
		return c_sort;
	}
	public void setC_sort(int c_sort) {
		this.c_sort = c_sort;
	}
	public int getViewnum() {
		return viewnum;
	}
	public void setViewnum(int viewnum) {
		this.viewnum = viewnum;
	}
	public String getC_pic() {
		return c_pic;
	}
	public void setC_pic(String c_pic) {
		this.c_pic = c_pic;
	}
	
	int viewnum;
	String c_pic;
	@Override
	public String toString() {
		return "Company [c_id=" + c_id + ", c_name=" + c_name + ", c_area="
				+ c_area + ", c_size=" + c_size + ", c_type=" + c_type
				+ ", c_brief=" + c_brief + ", c_state=" + c_state + ", c_sort="
				+ c_sort + ", c_viewnum=" + c_viewnum + ", viewnum=" + viewnum
				+ ", c_pic=" + c_pic + "]";
	}
}
