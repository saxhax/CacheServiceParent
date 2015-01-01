package com.unsa.pmf.ws.server.client;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unsa.pmf.ws.common.data.Field;
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
				List<Field> values = new ArrayList<Field>();
				values.add(new Field("name", "akif" + i));
				values.add(new Field("age", "" + i));
				values.add(new Field("state", "bih"));
				values.add(new Field("state2", "HIB"));
				obj.putValues(session, values);
			}
			ArrayList<Field> values = new ArrayList<Field>();
			values.add(new Field("state2", "HIB"));
			values.add(new Field("age", "48"));
			Filter filter = new Filter();
			Condition condition = new Condition();
			condition.setLimit(10);
			filter.setCondition(condition);
			filter.setFindFields(values);
			Date date = new Date();
			System.out.println(date);
			System.out.println(obj.getValues(session, filter).getFoundRows());
			System.out.println(new Date());
			System.out.println(System.currentTimeMillis() - date.getTime());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
