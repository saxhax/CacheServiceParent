package com.unsa.pmf.ws.service.cache.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.unsa.pmf.ws.service.cache.CacheService;

@WebService(endpointInterface="com.unsa.pmf.ws.service.cache.CacheService")
public class CacheServiceImpl implements CacheService{

	/**
	 * Default constructor
	 */
	public CacheServiceImpl(){}

	@Override
	@WebMethod
	public boolean isServiceStarted(@WebParam(name = "serviceName") String serviceName) {
		return false;
	}

	@Override
	@WebMethod
	public SessionImpl startService(@WebParam(name = "serviceName") String serviceName) {
		return null;
	}
}
