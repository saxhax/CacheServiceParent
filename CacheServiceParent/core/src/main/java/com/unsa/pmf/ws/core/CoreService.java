package com.unsa.pmf.ws.core;

import java.util.List;

import com.unsa.pmf.ws.core.config.Configurations;
import com.unsa.pmf.ws.core.data.Data;
import com.unsa.pmf.ws.core.filter.Filter;
import com.unsa.pmf.ws.core.session.Session;
import com.unsa.pmf.ws.core.session.SessionFactory;

public class CoreService {

	public Session createCacheService(Configurations configurations){
		return SessionFactory.getSession(configurations.getName());
	}
	
	public Session getCacheService(String name){
		return SessionFactory.getSession(name);
	}

	public Session putValues(Session session,  List<String> values){
		return SessionFactory.getSession(session.getSessionName());
	}

	public Data getValues(Session session, Filter filter){
		return new Data();
	}

	public void closeSession(Session session) {
	}
}
