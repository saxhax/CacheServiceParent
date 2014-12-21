package com.unsa.pmf.ws.service.cache;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.unsa.pmf.ws.core.config.Configurations;
import com.unsa.pmf.ws.core.data.Data;
import com.unsa.pmf.ws.core.filter.Filter;
import com.unsa.pmf.ws.core.session.Session;

@WebService
public interface CacheService{

	/**
	 * Check is service started
	 * @param serviceName
	 * @return
	 */
	@WebMethod
	public Session createCacheService(Configurations configurations);

	/**
	 * Start new service
	 * @param serviceName
	 * @return
	 * 		Service session
	 */
	@WebMethod
	public Session getCacheServiceSession(String name);

	/**
	 * Put new values to cache
	 * @param session
	 * @param values
	 * @return
	 */
	@WebMethod
	public Session putValues(Session session, List<String> values);
	
	/**
	 * Get values with specific filter
	 * @param session
	 * @param filter
	 * @return
	 */
	@WebMethod
	public Data getValues(Session session, Filter filter);
	
	/**
	 * Close session
	 * @param session
	 */
	@WebMethod
	public void closeSession(Session session);
}