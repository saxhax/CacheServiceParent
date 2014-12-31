package com.unsa.pmf.ws.server.client;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unsa.pmf.ws.common.data.Set;
import com.unsa.pmf.ws.common.filter.Condition;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.rmi.RemoteServer;
import com.unsa.pmf.ws.common.session.Session;

public class Client {
	public static void main(String arg[]) {
		try {

			RemoteServer obj = (RemoteServer) Naming.lookup("rmi://localhost:5005/RemoteServerImpl");
			
			Session session = obj.getCacheService("simpleName");
			
			for (int i = 0; i < 0; i++){
				List<Set> values = new ArrayList<Set>();
				values.add(new Set("name", "akif" + i));
				values.add(new Set("age", "" + i));
				values.add(new Set("state", "bih"));
				values.add(new Set("state2", "HIB"));
				obj.putValues(session, values);
			}
			ArrayList<Set> values = new ArrayList<Set>();
			values.add(new Set("state2", "HIB"));
			values.add(new Set("age", "48"));
			Filter filter = new Filter();
			Condition condition = new Condition();
			condition.setLimit(10);
			filter.setCondition(condition);
			filter.setSpecificData(values);
			Date date = new Date();
			System.out.println(date);
			System.out.println(obj.getValues(session, filter).getSpecificValues());
			System.out.println(new Date());
			System.out.println(System.currentTimeMillis() - date.getTime());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
