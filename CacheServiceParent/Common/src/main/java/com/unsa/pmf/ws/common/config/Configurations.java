package com.unsa.pmf.ws.common.config;

import java.io.Serializable;

public class Configurations implements Serializable{
	
	private static final long serialVersionUID = 4246133917987293684L;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
