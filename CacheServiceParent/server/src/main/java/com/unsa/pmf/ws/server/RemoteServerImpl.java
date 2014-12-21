package com.unsa.pmf.ws.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.rmi.RemoteServer;
import com.unsa.pmf.ws.common.session.Session;

public final class RemoteServerImpl extends UnicastRemoteObject implements RemoteServer{
	
	private static final long serialVersionUID = -2795486890017299452L;

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(5005);
			RemoteServerImpl obj = new RemoteServerImpl();
			Naming.rebind("rmi://localhost:5005/RemoteServerImpl", obj);
		} catch (Exception e) {
			System.out.println("RemoteServerImpl error: " + e.getMessage());
		}
	}

	public RemoteServerImpl() throws RemoteException {
		super();
	}
	
	public Session createCacheService(Configurations configurations) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public Session getCacheService(String name) throws RemoteException{
		
		return new Session();
	}

	public Session putValues(Session session, List<String> values) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public Data getValues(Session session, Filter filter) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean closeSession(Session session) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

}
