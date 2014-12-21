package com.unsa.pmf.ws.service.cache.client;

import com.unsa.pmf.ws.service.cache.impl.CacheServiceImplService;

public class CacheServiceClient {

	public static void main(String[] args) {
		CacheServiceImplService service = new CacheServiceImplService();
		System.out.println(service.getCacheServiceImplPort().isServiceStarted("name"));
	}
}
