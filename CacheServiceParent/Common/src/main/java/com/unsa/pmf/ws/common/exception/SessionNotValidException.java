package com.unsa.pmf.ws.common.exception;

public class SessionNotValidException extends Exception {
	
	private static final long serialVersionUID = 6097249493227887464L;

	public SessionNotValidException(String reason) {
		super(reason);
	}
	
	public SessionNotValidException() {
		super("This session is not valid");
	}
}
