package com.unsa.pmf.ws.dal;

import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.dal.client.Client;
import com.unsa.pmf.ws.dal.map.Mapper;

public class Dal {
	
	private Client client = new Client();
	
	public void storeSession(Session session){
		client.storeSession(Mapper.getSession(session));
	}
	
	public void removeSession(Session session){
		client.removeSession(Mapper.getSession(session));
	}
	
	public static void main(String[] args) {
		Dal dal = new Dal();
		Session session = new Session();
		session.setSessionName("sdf");
		dal.storeSession(session);
	}
}
