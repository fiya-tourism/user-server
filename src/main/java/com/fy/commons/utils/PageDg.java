package com.fy.commons.utils;


public class PageDg {
	//当前页
	private Integer page=1;
	//每页条数
	private Integer rows=3;
	//排序方式 desc asc 
	private String order = "desc";
	//排序字段
	private String sort;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	

}
