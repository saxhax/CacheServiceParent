package com.unsa.pmf.ws.core.session;

import java.util.UUID;

import com.unsa.pmf.ws.core.config.Configurations;

public class SessionFactory {

	public static Session getSession(String name){
		Session session = new Session();
		session.setSessionName(name);
		session.setSessionId(UUID.randomUUID().toString());
		return session;
	}
	
	public static Configurations getConfiguration(Session session){
		Configurations config = new Configurations();
		config.setName(session.getSessionName());
		return config;
	}

	public static boolean isValidSession(Session session) {
		return true;
	}
}
