package com.unsa.pmf.ws.service.cache.impl;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.unsa.pmf.ws.service.cache.CacheService;
import com.unsa.pmf.ws.core.config.Configurations;
import com.unsa.pmf.ws.core.data.Data;
import com.unsa.pmf.ws.core.CoreService;
import com.unsa.pmf.ws.core.filter.Filter;
import com.unsa.pmf.ws.core.session.Session;
import com.unsa.pmf.ws.core.session.SessionFactory;

@WebService(endpointInterface="com.unsa.pmf.ws.service.cache.CacheService")
public class CacheServiceImpl implements CacheService{

	/**
	 * Default constructor
	 */
	public CacheServiceImpl(){}

	@WebMethod
	public Session createCacheService(Configurations configurations) {
		CoreService service = new CoreService();
		service.createCacheService(configurations);
		return SessionFactory.getSession(configurations.getName());
	}

	@WebMethod
	public Session getCacheService(String name) {
		return SessionFactory.getSession(name);
	}

	@WebMethod
	public Session putValues(Session session, List<String> values) {
		CoreService service = new CoreService();
		service.putValues(SessionFactory.getConfiguration(session), values);
		return session;
	}

	@WebMethod
	public Data getValues(Session session, Filter filter) {
		CoreService service = new CoreService();
		return service.getValues(SessionFactory.getConfiguration(session), filter);
	}
}
