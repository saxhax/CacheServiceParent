package com.unsa.pmf.ws.common.filter;

import java.io.Serializable;

public class Condition implements Serializable{

	private static final long serialVersionUID = -8330868893701213040L;
	
	private Integer limit = null;
	private Boolean useCache = true;
	
	public Condition(){}
	
	public Integer getLimit() {
		return limit;
	}
	
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Boolean getUseCache() {
		return useCache;
	}

	public void setUseCache(Boolean useCache) {
		this.useCache = useCache;
	}
}
