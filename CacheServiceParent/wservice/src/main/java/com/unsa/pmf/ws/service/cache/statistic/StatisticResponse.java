package com.unsa.pmf.ws.service.cache.statistic;

import java.util.ArrayList;
import java.util.List;

public class StatisticResponse {
	private List<String> insert = new ArrayList<String>();
	private List<String> pull = new ArrayList<String>();
	private String message = "";
	
	public List<String> getInsert() {
		return insert;
	}
	public void setInsert(List<String> insert) {
		this.insert = insert;
	}
	public List<String> getPull() {
		return pull;
	}
	public void setPull(List<String> pull) {
		this.pull = pull;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
