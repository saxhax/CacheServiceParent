package com.unsa.pmf.ws.service.cache.statistic;

import com.unsa.pmf.ws.common.exception.SessionNotValidException;
import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.service.cache.exception.ParameterNotValidException;

public class StatisticParameter {
	private Session session = null;
	private Integer limitRow = null;
	private Integer limitField = null;
	private Integer diffKeys = null;
	private Integer diffValues = null;
	
	public void parseSession(String id, String name) throws SessionNotValidException {
		if (id == null || name == null || id.isEmpty() || name.isEmpty() || id.length() != 36) {
			throw new SessionNotValidException("Session is not valid for name: " + name + " and idd: " + id);
		} else {
			session = new Session();
			session.setSessionId(id);
			session.setSessionName(name);
		}
	}
	
	public void parseLimitRow(String limitRow) throws ParameterNotValidException {
		try {
			this.limitRow = Integer.parseInt(limitRow);
	    	if (this.limitRow < 1 || this.limitRow > 1000000) {
	    		throw new ParameterNotValidException("Number of rows should be between 1 - 1000000");
	    	}
	    } catch (Exception e) {
	    	throw new ParameterNotValidException(e.getMessage());
	    }
	}
	
	public void parseLimitField(String limitField) throws ParameterNotValidException {
		try {
			this.limitField = Integer.parseInt(limitField);
	    	if (this.limitField < 1 || this.limitField > 500) {
	    		throw new ParameterNotValidException("Number of fields should be between 1 - 500");
	    	}
	    } catch (Exception e) {
	    	throw new ParameterNotValidException(e.getMessage());
	    }
	}
	
	public void parseDiffKeys(String keys) throws ParameterNotValidException {
		try {
			this.diffKeys = Integer.parseInt(keys);
	    	if (this.diffKeys < 1 || this.diffKeys > 1000) {
	    		throw new ParameterNotValidException("Number of different keys should be between 1 - 1000");
	    	}
	    } catch (Exception e) {
	    	throw new ParameterNotValidException(e.getMessage());
	    }
	}
	
	public void parseDiffValues(String values) throws ParameterNotValidException {
		try {
			this.diffValues = Integer.parseInt(values);
	    	if (this.diffValues < 1 || this.diffValues > this.limitRow) {
	    		throw new ParameterNotValidException("Number of different values should be between 1 - " + this.limitRow);
	    	}
	    } catch (Exception e) {
	    	throw new ParameterNotValidException(e.getMessage());
	    }
	}
	
	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	public Integer getLimitRow() {
		return limitRow;
	}
	
	public void setLimitRow(int limitRow) {
		this.limitRow = limitRow;
	}
	
	public Integer getLimitField() {
		return limitField;
	}
	
	public void setLimitField(int limitField) {
		this.limitField = limitField;
	}

	public Integer getDiffKeys() {
		return diffKeys;
	}

	public void setDiffKeys(Integer diffKeys) {
		this.diffKeys = diffKeys;
	}

	public Integer getDiffValues() {
		return diffValues;
	}

	public void setDiffValues(Integer diffValues) {
		this.diffValues = diffValues;
	}

	public void setLimitRow(Integer limitRow) {
		this.limitRow = limitRow;
	}

	public void setLimitField(Integer limitField) {
		this.limitField = limitField;
	}
}
