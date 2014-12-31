package com.unsa.pmf.ws.common.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Row implements Serializable{
	private static final long serialVersionUID = -9097096452832154266L;

	private List<Set> rowValues;
	
	public Row(){
		rowValues = new ArrayList<Set>();
	}

	public List<Set> getRowValues() {
		return rowValues;
	}

	public void setRowValues(List<Set> rowValues) {
		this.rowValues = rowValues;
	}

	public String toString() {
		return rowValues != null ? rowValues.toString() : "null";
	}
}
