package com.unsa.pmf.ws.service.cache.exception;

public class ParameterNotValidException extends Exception{

	private static final long serialVersionUID = 969315980844861479L;

	public ParameterNotValidException() {
		super("Parameter is not valid");
	}
	
	public ParameterNotValidException(String reason) {
		super(reason);
	}
}
