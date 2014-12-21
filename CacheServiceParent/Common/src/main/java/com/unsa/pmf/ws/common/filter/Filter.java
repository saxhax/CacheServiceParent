package com.unsa.pmf.ws.common.filter;

import java.io.Serializable;
import java.util.List;

public class Filter implements Serializable{

	List<Condition> conditions;

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
}
