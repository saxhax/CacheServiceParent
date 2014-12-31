package com.unsa.pmf.ws.dal.map;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.unsa.pmf.ws.common.data.Set;
import com.unsa.pmf.ws.common.session.Session;

public class Mapper {
	
	/**
	 * Create session
	 * @param entity
	 * @return
	 */
	public static Session getSession(com.unsa.pmf.ws.dal.entity.Session entity) {
		Session session = new Session();
		session.setSessionId(entity.getId());
		session.setSessionName(entity.getName());
		return session;
	}

	/**
	 * Create session
	 * @param session
	 * @return
	 */
	public static com.unsa.pmf.ws.dal.entity.Session getSession(Session session) {
		com.unsa.pmf.ws.dal.entity.Session entity = new com.unsa.pmf.ws.dal.entity.Session();
		entity.setId(session.getSessionId());
		entity.setName(session.getSessionName());
		return entity;
	}
	
	/**
	 * Create object
	 * @param data
	 * @return
	 */
	public static BasicDBObject generateObject(List<Set> data){
		List<BasicDBObject> objects = new ArrayList<BasicDBObject>();
		if (data != null && !data.isEmpty()){
			for(Set set : data){
				BasicDBObject object = new BasicDBObject(); 
				object.put(set.getKey(), set.getValue());
				objects.add(object);
			}
		}

		BasicDBObject query = new BasicDBObject();
		query.put("$and", objects);
		return query;
	}
	
	/**
	 * Create list
	 * @param data
	 * @return
	 */
	public static List<Set> generateList(DBObject object){
		List<Set> data = new ArrayList<Set>();
		for (String key : object.keySet()){
			try {
				Set set = new Set();
				set.setKey(key);
				set.setValue(object.get(key).toString());
				data.add(set);
			} catch(Exception e){
				
			}
		}
		return data;
	}
}
