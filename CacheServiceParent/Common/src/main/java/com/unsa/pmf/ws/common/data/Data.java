package com.unsa.pmf.ws.common.data;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable{
	private static final long serialVersionUID = 2990802288841200353L;
	
	private ArrayList<Row> specificValues;
	
	public Data() {
		this.specificValues = new ArrayList<Row>();
	}
	
	public Data(ArrayList<Row> specificValues) {
		this.specificValues = specificValues;
	}

	public ArrayList<Row> getSpecificValues() {
		return specificValues;
	}

	public void setSpecificValues(ArrayList<Row> specificValues) {
		this.specificValues = specificValues;
	}
}
