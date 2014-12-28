package com.unsa.pmf.ws.common.filter;

import java.io.Serializable;
import java.util.List;

public class Filter implements Serializable{
	private static final long serialVersionUID = -9064767939839400543L;
	private List<Condition> conditions;
	private List<String> data;

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
}
