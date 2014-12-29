package com.unsa.pmf.ws.common.data;

import java.io.Serializable;
import java.util.ArrayList;

public class Row implements Serializable{
	private static final long serialVersionUID = -9097096452832154266L;
	private ArrayList<String> rowValues;
	
	public Row(){
		rowValues = new ArrayList<String>();
	}
	
	public Row(ArrayList<String> rowValues){
		this.rowValues = rowValues;
	}

	public ArrayList<String> getRowValues() {
		return rowValues;
	}

	public void setRowValues(ArrayList<String> rowValues) {
		this.rowValues = rowValues;
	}
}
