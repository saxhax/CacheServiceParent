package com.unsa.pmf.ws.rest.cache;

import javax.ws.rs.core.Response;

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
	public Response putValues(String sessionId, String name, String count, String values) throws Exception;
	
	/**
	 * Get values with specific filter
	 * @param session
	 * @param filter
	 * @return
	 */
	public Response getValues(String sessionId, String name, String limit, String key, String value) throws Exception;
	
	/**
	 * Close session
	 * @param session
	 */
	public Response closeSession(String sessionId, String name) throws Exception;
}