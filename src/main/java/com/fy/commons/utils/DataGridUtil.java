package com.fy.commons.utils;

import java.util.List;

public class DataGridUtil<T> {

	private Long total;
	private List<T> rows;

	public Long getTotal() {
		return this.total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
	
	
}
