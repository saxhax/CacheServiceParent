package com.unsa.pmf.ws.common.rmi;

import java.rmi.Remote;
import java.util.List;

import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.data.Set;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.session.Session;

public interface RemoteServer extends Remote{

	public Session createCacheService(Configurations configurations) throws Exception;
	
	public Session getCacheService(String name) throws Exception;

	public Session putValues(Session session,  List<Set> values) throws Exception;

	public Data getValues(Session session, Filter filter) throws Exception;

	public Boolean closeSession(Session session) throws Exception;
}
