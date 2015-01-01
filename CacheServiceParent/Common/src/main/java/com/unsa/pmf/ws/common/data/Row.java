package com.unsa.pmf.ws.common.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Row implements Serializable{
	private static final long serialVersionUID = -9097096452832154266L;

	private List<Field> fields;
	
	public Row(){
		fields = new ArrayList<Field>();
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public String toString() {
		return fields != null ? fields.toString() : "null";
	}
}
