package com.unsa.pmf.ws.common.exception;

public class CacheAlreadyExistException extends Exception {

	private static final long serialVersionUID = 6525897676193592083L;

	public CacheAlreadyExistException(String reason) {
		super(reason);
	}
	
	public CacheAlreadyExistException() {
		super("Cache with your name already exist");
	}
}
