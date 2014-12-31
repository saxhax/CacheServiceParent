package com.unsa.pmf.ws.service.validate;

import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.session.SessionFactory;

public class Validate {
	
	public static boolean validateSession(Session session){
		return session.isSessionValid();
	}
	
	public static boolean validateConfiguration(Configurations configurations){
		return validateSession(SessionFactory.getSession(configurations.getName()));
	}
}
