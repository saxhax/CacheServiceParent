package com.unsa.pmf.ws.common.exception;

public class CacheNotExistException extends Exception {
	
	private static final long serialVersionUID = 2029496056870976279L;

	public CacheNotExistException(String reason) {
		super(reason);
	}
	
	public CacheNotExistException() {
		super("Cache not exist, please create new cache with this name");
	}
}
