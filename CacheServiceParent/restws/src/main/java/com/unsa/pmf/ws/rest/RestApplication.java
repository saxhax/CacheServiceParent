package com.unsa.pmf.ws.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import com.unsa.pmf.ws.rest.cache.impl.RestCacheServiceImpl;
 

public class RestApplication  extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	 
	public RestApplication() {
		singletons.add(new RestCacheServiceImpl());
	}
 
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
