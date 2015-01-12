package com.unsa.pmf.ws.common.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.unsa.pmf.ws.common.data.Field;

public class Filter implements Serializable{
	private static final long serialVersionUID = -9064767939839400543L;
	private Condition condition;
	private List<Field> findFields;

	public Filter(){
		findFields = new ArrayList<Field>();
	}
	
	public Filter(List<Field> findFields) {
		this.findFields = findFields;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public List<Field> getFindFields() {
		return findFields;
	}

	public void setFindFields(List<Field> findFields) {
		this.findFields = findFields;
	}
}
