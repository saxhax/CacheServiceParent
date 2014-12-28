package com.unsa.pmf.ws.common.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable{
	private static final long serialVersionUID = 2990802288841200353L;
	
	private List<List<String>> data;
	
	public Data() {
		this.data = new ArrayList<List<String>>();
	}
	
	public Data(List<List<String>> data) {
		this.data = data;
	}

	public List<List<String>> getData() {
		return data;
	}

	public void setData(List<List<String>> data) {
		this.data = data;
	}
}
