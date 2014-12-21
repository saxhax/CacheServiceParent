package com.unsa.pmf.ws.common.config;

import java.io.Serializable;

public class Configurations implements Serializable{
	
	private int numberOfFields;
	private String name;
	
	public int getNumberOfFields() {
		return numberOfFields;
	}
	public void setNumberOfFields(int numberOfFields) {
		this.numberOfFields = numberOfFields;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
