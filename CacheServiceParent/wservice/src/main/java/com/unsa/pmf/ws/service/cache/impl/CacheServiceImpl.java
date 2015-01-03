package com.unsa.pmf.ws.service.cache.impl;

import java.io.IOException;
import java.rmi.Naming;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unsa.pmf.ws.service.Service;
import com.unsa.pmf.ws.service.cache.CacheService;
import com.unsa.pmf.ws.service.validate.Validate;
import com.unsa.pmf.ws.common.rmi.RemoteServer;
import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.data.Field;
import com.unsa.pmf.ws.common.filter.Filter;

@WebService(endpointInterface="com.unsa.pmf.ws.service.cache.CacheService")
public class CacheServiceImpl extends HttpServlet implements CacheService{

	/**
	 * Default constructor
	 */
	public CacheServiceImpl(){}

	@WebMethod
	public Session createCacheService(@WebParam(name = "configuration") Configurations configurations) throws Exception{
		if (!Validate.validateConfiguration(configurations)){
			return new Session();
		}
		RemoteServer service = getRemoteServer();
		return service.createCacheService(configurations);
	}

	@WebMethod
	public Session getCacheServiceSession(@WebParam(name = "name") String name) throws Exception{
		RemoteServer service = getRemoteServer();
		return service.getCacheService(name);
	}

	@WebMethod
	public Session putValues(@WebParam(name = "session") Session session,@WebParam(name = "data")  List<Field> values) throws Exception {
		if (!Validate.validateSession(session)){
			return new Session();
		}
		RemoteServer service = getRemoteServer();
		return service.putValues(session, values);
	}

	@WebMethod
	public Data getValues(@WebParam(name = "session") Session session,@WebParam(name = "filter")  Filter filter) throws Exception{
		if (!Validate.validateSession(session)){
			return new Data();
		}
		RemoteServer service = getRemoteServer();
		return service.getValues(session, filter);
	}

	@WebMethod
	public void closeSession(@WebParam(name = "session") Session session) throws Exception{
		if (!Validate.validateSession(session)){
			return;
		}
		RemoteServer service = getRemoteServer();
		service.closeSession(session);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
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
