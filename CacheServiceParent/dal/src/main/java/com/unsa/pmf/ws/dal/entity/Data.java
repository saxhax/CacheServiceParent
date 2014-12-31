package com.unsa.pmf.ws.dal.entity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;


/**
 * The persistent class for the data database table.
 * 
 */
@Entity
@Table(name="data")
@NamedQuery(name="Data.findAll", query="SELECT d FROM Data d")
public class Data implements SQLEnitiy {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	private Timestamp cts;

	@Column(name="data_key")
	private String dataKey;

	@Column(name="data_value")
	private String dataValue;

	@Lob
	private String other;

	public Data() {}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCts() {
		return this.cts;
	}

	public void setCts(Timestamp cts) {
		this.cts = cts;
	}

	public String getDataKey() {
		return this.dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public String getDataValue() {
		return this.dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}