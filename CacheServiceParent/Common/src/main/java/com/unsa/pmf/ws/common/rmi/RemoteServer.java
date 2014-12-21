package com.unsa.pmf.ws.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.session.Session;

public interface RemoteServer extends Remote{

	public Session createCacheService(Configurations configurations) throws RemoteException;
	
	public Session getCacheService(String name) throws RemoteException;

	public Session putValues(Session session,  List<String> values) throws RemoteException;

	public Data getValues(Session session, Filter filter) throws RemoteException;

	public Boolean closeSession(Session session) throws RemoteException;
}
