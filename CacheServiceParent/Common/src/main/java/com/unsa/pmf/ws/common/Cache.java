package com.unsa.pmf.ws.common;

import java.util.UUID;

public class Cache {

	private UUID id;
	private String name;
	
	public Cache(){}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
