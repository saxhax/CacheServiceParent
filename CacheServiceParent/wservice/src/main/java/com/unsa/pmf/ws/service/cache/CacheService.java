package com.unsa.pmf.ws.service.cache;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.data.Field;
import com.unsa.pmf.ws.common.filter.Filter;

@WebService
public interface CacheService{

	/**
	 * Check is service started
	 * @param serviceName
	 * @return
	 */
	@WebMethod
	public Session createCacheService(@WebParam(name = "configuration") Configurations configurations) throws Exception;

	/**
	 * Start new service
	 * @param serviceName
	 * @return
	 * 		Service session
	 */
	@WebMethod
	public Session getCacheServiceSession(@WebParam(name = "name") String name) throws Exception;

	/**
	 * Put new values to cache
	 * @param session
	 * @param values
	 * @return
	 */
	@WebMethod
	public Session putValues(@WebParam(name = "session") Session session,@WebParam(name = "data")  List<Field> values) throws Exception;
	
	/**
	 * Get values with specific filter
	 * @param session
	 * @param filter
	 * @return
	 */
	@WebMethod
	public Data getValues(@WebParam(name = "session") Session session,@WebParam(name = "filter")  Filter filter) throws Exception;
	
	/**
	 * Close session
	 * @param session
	 */
	@WebMethod
	public void closeSession(@WebParam(name = "session") Session session) throws Exception;
}