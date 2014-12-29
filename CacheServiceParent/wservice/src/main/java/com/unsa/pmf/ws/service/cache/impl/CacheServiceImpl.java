package com.unsa.pmf.ws.service.cache.impl;

import java.rmi.Naming;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.unsa.pmf.ws.service.Service;
import com.unsa.pmf.ws.service.cache.CacheService;
import com.unsa.pmf.ws.service.validate.Validate;
import com.unsa.pmf.ws.common.rmi.RemoteServer;
import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.filter.Filter;

@WebService(endpointInterface="com.unsa.pmf.ws.service.cache.CacheService")
public class CacheServiceImpl implements CacheService{

	/**
	 * Default constructor
	 */
	public CacheServiceImpl(){}

	@WebMethod
	public Session createCacheService(Configurations configurations) throws Exception{
		if (!Validate.validateConfiguration(configurations)){
			return new Session();
		}
		RemoteServer service = getRemoteServer();
		return service.createCacheService(configurations);
	}

	@WebMethod
	public Session getCacheServiceSession(String name) throws Exception{
		RemoteServer service = getRemoteServer();
		return service.getCacheService(name);
	}

	@WebMethod
	public Session putValues(Session session, List<String> values) throws Exception {
		if (!Validate.validateSession(session)){
			return new Session();
		}
		RemoteServer service = getRemoteServer();
		return service.putValues(session, values);
	}

	@WebMethod
	public Data getValues(Session session, Filter filter) throws Exception{
		if (!Validate.validateSession(session)){
			return new Data();
		}
		RemoteServer service = getRemoteServer();
		return service.getValues(session, filter);
	}

	@WebMethod
	public void closeSession(Session session) throws Exception{
		if (!Validate.validateSession(session)){
			return;
		}
		RemoteServer service = getRemoteServer();
		service.closeSession(session);
	}
	
	private RemoteServer getRemoteServer() throws Exception{
		try {
			RemoteServer remoteServer;
			Object object = Naming.lookup( "rmi://localhost:5005/RemoteServerImpl");
			remoteServer = (RemoteServer) object;
			return remoteServer;
		} catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}
}
