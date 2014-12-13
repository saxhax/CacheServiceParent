package com.unsa.pmf.ws.service.cache;

import com.unsa.pmf.ws.service.Service;
import com.unsa.pmf.ws.service.Session;
import com.unsa.pmf.ws.service.cache.impl.SessionImpl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface CacheService{

	/**
	 * Check is service started
	 * @param serviceName
	 * @return
	 */
	@WebMethod
	public boolean isServiceStarted(@WebParam(name = "serviceName")String serviceName);

	/**
	 * Start new service
	 * @param serviceName
	 * @return
	 * 		Service session
	 */
	@WebMethod
	public SessionImpl startService(@WebParam(name = "serviceName")String serviceName);
}