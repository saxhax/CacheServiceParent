package com.unsa.pmf.ws.service.validate;

import com.unsa.pmf.ws.core.config.Configurations;
import com.unsa.pmf.ws.core.session.Session;
import com.unsa.pmf.ws.core.session.SessionFactory;

public class Validate {
	
	public static boolean validateSession(Session session){
		boolean isValid = true;
		isValid = isValid && session.isSessionValid();
		isValid = isValid && SessionFactory.isValidSession(session);
		return isValid;
	}
	
	public static boolean validateConfiguration(Configurations configurations){
		boolean isValid = true;
		isValid = isValid && (configurations.getNumberOfFields() > 0);
		isValid = isValid && validateSession(SessionFactory.getSession(configurations.getName()));
		return isValid;
	}
}
