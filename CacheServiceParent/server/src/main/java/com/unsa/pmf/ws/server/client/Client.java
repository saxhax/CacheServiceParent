package com.unsa.pmf.ws.server.client;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.rmi.RemoteServer;
import com.unsa.pmf.ws.common.session.Session;

public class Client {
	public static void main(String arg[]) {
		try {

			RemoteServer obj = (RemoteServer) Naming.lookup("rmi://localhost:5005/RemoteServerImpl");
			Configurations configuration = new Configurations();
			configuration.setName("simpleName");
			
			Session session = obj.createCacheService(configuration);
			
			for (int i = 0; i < 70; i++){
				List<String> values = new ArrayList<String>();
				values.add("first" + i);
				values.add("second" + i);
				obj.putValues(session, values);
			}
			ArrayList<String> values = new ArrayList<String>();
			values.add("first5");
			Filter filter = new Filter();
			filter.setSpecificData(values);
			Date date = new Date();
			System.out.println(date);
			System.out.println(obj.getValues(session, filter).getSpecificValues());
			System.out.println(new Date());
			System.out.println(System.currentTimeMillis() - date.getTime());
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
