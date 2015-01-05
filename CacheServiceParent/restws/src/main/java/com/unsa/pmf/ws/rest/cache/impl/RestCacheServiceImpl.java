package com.unsa.pmf.ws.rest.cache.impl;

import java.rmi.Naming;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.data.Field;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.rmi.RemoteServer;
import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.rest.Service;
import com.unsa.pmf.ws.rest.cache.CacheService;
import com.unsa.pmf.ws.rest.validate.Validate;

@Path("/cache")
public class RestCacheServiceImpl implements CacheService, Service{

	private static final long serialVersionUID = -2089356745994285583L;

	/**
	 * Default constructor
	 */
	public RestCacheServiceImpl(){}


	@GET
	@Path("/{pathParameter}/one")
	public Response responseMsg(
			@PathParam("pathParameter") String pathParameter,
			@DefaultValue("Nothing to say") 
			@QueryParam("session") String session) {

		String response = "Hellorom: f " + pathParameter + " : " + session;

		return Response.status(200).entity(response).build();
	}
	
	@GET
	@Path("/{pathParameter}/two")
	public Response responseMsg2(
			@PathParam("pathParameter") String pathParameter,
			@DefaultValue("Nothing to say") 
			@QueryParam("session") String session) {

		String response = "Hellorom:2 f " + pathParameter + " : " + session;

		return Response.status(200).entity(response).build();
	}

	@GET
	@Path("/{pathParameter}/createCacheService")
	public Response createCacheService(@QueryParam("name") String name) throws Exception{
		Configurations configurations = new Configurations();
		configurations.setName(name);
		Validate.validateConfiguration(configurations);
		RemoteServer service = getRemoteServer();
		Session session = service.createCacheService(configurations);
		return Response.status(200).entity(session.toString()).build();
	}

	@GET
	@Path("/{pathParameter}/getCacheServiceSession")
	public Response getCacheServiceSession(String name) throws Exception{
		RemoteServer service = getRemoteServer();
		return null;	
	}

	@GET
	@Path("/{pathParameter}/putValues")
	public Response putValues(Session session, List<Field> values) throws Exception {
		if (!Validate.validateSession(session)){
		}
		RemoteServer service = getRemoteServer();
		return null;	
	}

	@GET
	@Path("/{pathParameter}/getValues")
	public Response getValues(Session session, Filter filter) throws Exception{
		if (!Validate.validateSession(session)){
		}
		RemoteServer service = getRemoteServer();
		return null;	
	}

	@GET
	@Path("/{pathParameter}/getValues")
	public Response closeSession(Session session) throws Exception{
		if (!Validate.validateSession(session)){
		}
		RemoteServer service = getRemoteServer();
		service.closeSession(session);
		return null;	
	}

	@GET
	@Path("/{pathParameter}/getName")
	public Response getName() {
		return Response.status(200).entity(Service.CACHE).build();
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
