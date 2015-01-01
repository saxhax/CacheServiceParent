package com.unsa.pmf.ws.common.data;

import java.io.Serializable;

public class Field implements Serializable{
	
	private static final long serialVersionUID = -369284050641102570L;
	private String key;
	private String value;

	public Field(){}
	public Field(String key, String value){
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString(){
		return "(key: " + key + ", value: " + value + ")"; 
	}
}
