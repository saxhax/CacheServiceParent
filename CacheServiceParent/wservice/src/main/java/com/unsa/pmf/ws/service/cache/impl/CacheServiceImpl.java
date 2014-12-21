package com.unsa.pmf.ws.service.cache.impl;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.unsa.pmf.ws.service.Service;
import com.unsa.pmf.ws.service.cache.CacheService;
import com.unsa.pmf.ws.service.validate.Validate;
import com.unsa.pmf.ws.core.config.Configurations;
import com.unsa.pmf.ws.core.data.Data;
import com.unsa.pmf.ws.core.CoreService;
import com.unsa.pmf.ws.core.filter.Filter;
import com.unsa.pmf.ws.core.session.Session;
import com.unsa.pmf.ws.core.session.SessionFactory;

@WebService(endpointInterface="com.unsa.pmf.ws.service.cache.CacheService")
public class CacheServiceImpl implements CacheService, Service{

	/**
	 * Default constructor
	 */
	public CacheServiceImpl(){}

	@WebMethod
	public Session createCacheService(Configurations configurations) {
		if (Validate.validateConfiguration(configurations)){
			return new Session();
		}
		CoreService service = new CoreService();
		return service.createCacheService(configurations);
	}

	@WebMethod
	public Session getCacheServiceSession(String name) {
		CoreService service = new CoreService();
		return service.getCacheService(name);
	}

	@WebMethod
	public Session putValues(Session session, List<String> values) {
		if (Validate.validateSession(session)){
			return new Session();
		}
		CoreService service = new CoreService();
		return service.putValues(session, values);
	}

	@WebMethod
	public Data getValues(Session session, Filter filter) {
		if (Validate.validateSession(session)){
			return new Session();
		}
		CoreService service = new CoreService();
		return service.getValues(session, filter);
	}

	@WebMethod
	public void closeSession(Session session) {
		if (Validate.validateSession(session)){
			return;
		}
		CoreService service = new CoreService();
		service.closeSession(session);
	}

	public String getName() {
		return Service.CACHE;
	}
}
