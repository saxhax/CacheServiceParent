package com.unsa.pmf.ws.common.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable{
	private static final long serialVersionUID = 2990802288841200353L;
	
	private List<Row> foundRows;
	
	public Data() {
		this.foundRows = new ArrayList<Row>();
	}

	public List<Row> getFoundRows() {
		return foundRows;
	}

	public void setFoundRows(List<Row> foundRows) {
		this.foundRows = foundRows;
	}
}
