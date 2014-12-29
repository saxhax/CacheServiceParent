package com.unsa.pmf.ws.common.filter;

import java.io.Serializable;
import java.util.ArrayList;

public class Filter implements Serializable{
	private static final long serialVersionUID = -9064767939839400543L;
	private ArrayList<Condition> conditions;
	private ArrayList<String> specificData;

	public Filter(){}
	
	public Filter(ArrayList<String> specificData) {
		this.specificData = specificData;
	}
	public ArrayList<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(ArrayList<Condition> conditions) {
		this.conditions = conditions;
	}

	public ArrayList<String> getSpecificData() {
		return specificData;
	}

	public void setSpecificData(ArrayList<String> specificData) {
		this.specificData = specificData;
	}
}
