package com.unsa.pmf.ws.common;

import java.util.ArrayList;
import java.util.List;

public class Entity {

	private List<Field> fields = new ArrayList<Field>();
	
	public Entity(){}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
}
