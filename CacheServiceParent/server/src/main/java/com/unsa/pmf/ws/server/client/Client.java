package com.unsa.pmf.ws.server.client;

import java.rmi.Naming;

import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.rmi.RemoteServer;

public class Client {
	public static void main(String arg[]) {
		try {

			RemoteServer obj = (RemoteServer) Naming.lookup("rmi://localhost:5005/RemoteServerImpl");
			Configurations configuration = new Configurations();
			configuration.setName("name2");
			configuration.setNumberOfFields(5);
			System.out.println(obj.createCacheService(configuration).getSessionId());
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
