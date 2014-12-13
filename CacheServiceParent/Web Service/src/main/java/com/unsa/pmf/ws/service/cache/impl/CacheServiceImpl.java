package com.unsa.pmf.ws.service.cache.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.unsa.pmf.ws.service.Service;
import com.unsa.pmf.ws.service.Session;
import com.unsa.pmf.ws.service.cache.CacheService;

@WebService(endpointInterface="com.unsa.pmf.ws.service.cache.CacheService")
public class CacheServiceImpl implements CacheService {

	@Override
	public boolean isServiceStarted(@WebParam(name = "serviceName") String serviceName) {
		return false;
	}

	@Override
	public Session startService(@WebParam(name = "serviceName") String serviceName) {
		return null;
	}

	@Override
	public String getName() {
		return Service.CACHE;
	}
}
