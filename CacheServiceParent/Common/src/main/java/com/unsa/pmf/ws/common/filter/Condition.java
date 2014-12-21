package com.unsa.pmf.ws.common.filter;

import java.io.Serializable;

public class Condition implements Serializable{

	private int field;
	private FilterType filterType;
	private String value;
	
	public int getField() {
		return field;
	}
	public void setField(int field) {
		this.field = field;
	}
	public FilterType getFilterType() {
		return filterType;
	}
	public void setFilterType(FilterType filterType) {
		this.filterType = filterType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
