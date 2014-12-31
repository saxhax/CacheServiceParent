package com.unsa.pmf.ws.common.filter;

import java.io.Serializable;
import java.util.ArrayList;

import com.unsa.pmf.ws.common.data.Set;

public class Filter implements Serializable{
	private static final long serialVersionUID = -9064767939839400543L;
	private Condition condition;
	private ArrayList<Set> specificData;

	public Filter(){}
	
	public Filter(ArrayList<Set> specificData) {
		this.specificData = specificData;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public ArrayList<Set> getSpecificData() {
		return specificData;
	}

	public void setSpecificData(ArrayList<Set> specificData) {
		this.specificData = specificData;
	}
}
