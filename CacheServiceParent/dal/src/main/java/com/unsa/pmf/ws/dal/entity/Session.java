package com.unsa.pmf.ws.dal.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@Table(name="session")
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	private Timestamp cts;

	private String name;

	public Session() {
	}

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}