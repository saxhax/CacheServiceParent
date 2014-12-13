package com.unsa.pmf.ws.service.cache;

import com.unsa.pmf.ws.service.Service;
import com.unsa.pmf.ws.service.Session;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface CacheService extends Service{

	/**
	 * Check is service started
	 * @param serviceName
	 * @return
	 */
	public boolean isServiceStarted(@WebParam(name = "serviceName")String serviceName);

	/**
	 * Start new service
	 * @param serviceName
	 * @return
	 * 		Service session
	 */
	public Session startService(@WebParam(name = "serviceName")String serviceName);
}