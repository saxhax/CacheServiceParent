package com.unsa.pmf.ws.rest.cache;

import java.util.List;

import javax.ws.rs.core.Response;

import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.data.Field;
import com.unsa.pmf.ws.common.filter.Filter;

public interface CacheService{

	/**
	 * Create cache service with name from configuration
	 * @param configurations
	 * @return
	 * @throws Exception
	 */
	public Response createCacheService(String name) throws Exception;

	 /**
	 * Get session for cache service
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Response getCacheServiceSession(String name) throws Exception;

	/**
	 * Put new values to cache
	 * @param session
	 * @param values
	 * @return
	 */
	public Response putValues(Session session, List<Field> values) throws Exception;
	
	/**
	 * Get values with specific filter
	 * @param session
	 * @param filter
	 * @return
	 */
	public Response getValues(Session session, Filter filter) throws Exception;
	
	/**
	 * Close session
	 * @param session
	 */
	public Response closeSession(Session session) throws Exception;
}