package com.unsa.pmf.ws.service.cache;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.data.Set;
import com.unsa.pmf.ws.common.filter.Filter;

@WebService
public interface CacheService{

	/**
	 * Check is service started
	 * @param serviceName
	 * @return
	 */
	@WebMethod
	public Session createCacheService(Configurations configurations) throws Exception;

	/**
	 * Start new service
	 * @param serviceName
	 * @return
	 * 		Service session
	 */
	@WebMethod
	public Session getCacheServiceSession(String name) throws Exception;

	/**
	 * Put new values to cache
	 * @param session
	 * @param values
	 * @return
	 */
	@WebMethod
	public Session putValues(Session session, List<Set> values) throws Exception;
	
	/**
	 * Get values with specific filter
	 * @param session
	 * @param filter
	 * @return
	 */
	@WebMethod
	public Data getValues(Session session, Filter filter) throws Exception;
	
	/**
	 * Close session
	 * @param session
	 */
	@WebMethod
	public void closeSession(Session session) throws Exception;
}