package com.unsa.pmf.ws.rest.cache.impl;

import java.rmi.Naming;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.data.Field;
import com.unsa.pmf.ws.common.filter.Condition;
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCacheService(@QueryParam("name") String name) throws Exception{
		Configurations configurations = new Configurations();
		configurations.setName(name);
		Validate.validateConfiguration(configurations);
		RemoteServer service = getRemoteServer();
		Session session = service.createCacheService(configurations);
		return Response.status(200).entity(session).build();
	}

	@GET
	@Path("/{pathParameter}/getCacheServiceSession")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCacheServiceSession(@QueryParam("name") String name) throws Exception{
		RemoteServer service = getRemoteServer();
		Session session = service.getCacheService(name);
		return Response.status(200).entity(session).build();
	}

	@GET
	@Path("/{pathParameter}/putValues")
	@Produces(MediaType.APPLICATION_JSON)
	public Response putValues(@QueryParam("sessionId") String sessionId, 
			@QueryParam("name") String name,
			@QueryParam("count") String count,
			@QueryParam("values") String values) throws Exception {
		Session session = new Session();
		session.setSessionId(sessionId);
		session.setSessionName(name);
		Validate.validateSession(session);
		RemoteServer service = getRemoteServer();
		//: TODO session = service.putValues(session, values)
		return Response.status(200).entity(session).build();
	}

	@GET
	@Path("/{pathParameter}/getValues")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValues(@QueryParam("sessionId") String sessionId, 
			@QueryParam("name") String name,
			@QueryParam("limit") String limit,
			@QueryParam("key") String key,
			@QueryParam("value") String value) throws Exception{
		Session session = new Session();
		session.setSessionId(sessionId);
		session.setSessionName(name);
		Validate.validateSession(session);
		int limitValue = 3;
		try {
			limitValue = Integer.parseInt(limit);
		} catch (Exception e) {
			limitValue = 10;
		} finally {
			if (limitValue > 100 || limitValue < 1) {
				limitValue = 3;
			}
		}
		Filter filter = new Filter();
		Condition condition = new Condition();
		condition.setLimit(limitValue);
		Field field = new Field();
		field.setKey(key);
		field.setValue(value);
		filter.setCondition(condition);
		filter.getFindFields().add(field);
		RemoteServer service = getRemoteServer();
		Data data = service.getValues(session, filter);
		return Response.status(200).entity(data).build();
	}

	@GET
	@Path("/{pathParameter}/closeSession")
	@Produces(MediaType.APPLICATION_JSON)
	public Response closeSession(@QueryParam("sessionId") String sessionId, 
			@QueryParam("name") String name) throws Exception {
		Session session = new Session();
		session.setSessionId(sessionId);
		session.setSessionName(name);
		Validate.validateSession(session);
		RemoteServer service = getRemoteServer();
		service.closeSession(session);
		return Response.status(200).entity("true").build();	
	}

	@GET
	@Path("/{pathParameter}/getName")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getName() {
		return Response.status(200).entity(Service.CACHE).build();
	}
	
	/**
	 * Get RMI connection
	 * @return
	 * @throws Exception
	 */
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
