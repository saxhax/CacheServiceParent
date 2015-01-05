package com.unsa.pmf.ws.common.session;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Akif on 13.12.2014.
 */
public class Session implements Serializable{
	
	private static final long serialVersionUID = -83626479858110244L;
	private String sessionId = UUID.randomUUID().toString();
	private String sessionName;
	private Boolean sessionValid;

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
	
	public String toString(){
		return "sessionId='" + sessionId + "'," + 
			   " sessionName='" + sessionName + "'," + 
			   " sessionValid='" + sessionValid + "'";
	}
}
