package com.unsa.pmf.ws.core;

import java.util.List;

import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.session.SessionFactory;

public class CoreService {

	public Session createCacheService(Configurations configurations){
		//Dal dal = new Dal();
		Session session = SessionFactory.getSession(configurations.getName());
		//dal.storeSession(session);
		return session;
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
