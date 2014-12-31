package com.unsa.pmf.ws.common.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable{
	private static final long serialVersionUID = 2990802288841200353L;
	
	private List<Row> specificValues;
	
	public Data() {
		this.specificValues = new ArrayList<Row>();
	}
	
	public List<Row> getSpecificValues() {
		return specificValues;
	}

	public void setSpecificValues(List<Row> specificValues) {
		this.specificValues = specificValues;
	}
}
