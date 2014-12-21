package com.unsa.pmf.ws.common.session;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Akif on 13.12.2014.
 */
public class Session implements Serializable{
	
	private String sessionId = UUID.randomUUID().toString();
	private String sessionName;
	private boolean sessionValid;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public boolean isSessionValid() {
    	if (sessionId == null || sessionId.length() == 0){
    		sessionValid = false;
    	} else {
    		sessionValid = true;
    	}
		return sessionValid;
	}

	public void setSessionValid(boolean sessionValid) {
		this.sessionValid = sessionValid;
	}
}
