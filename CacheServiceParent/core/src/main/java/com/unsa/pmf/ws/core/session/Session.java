package com.unsa.pmf.ws.core.session;

/**
 * Created by Akif on 13.12.2014.
 */
public class Session {
	
	private String sessionId;
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
