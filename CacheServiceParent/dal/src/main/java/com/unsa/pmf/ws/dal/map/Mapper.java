package com.unsa.pmf.ws.dal.map;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.unsa.pmf.ws.common.data.Field;
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
	public static BasicDBObject generateObject(List<Field> data){
		List<BasicDBObject> objects = new ArrayList<BasicDBObject>();
		if (data != null && !data.isEmpty()){
			for(Field field : data){
				BasicDBObject object = new BasicDBObject(); 
				object.put(field.getKey(), field.getValue());
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
	public static List<Field> generateList(DBObject object){
		List<Field> data = new ArrayList<Field>();
		for (String key : object.keySet()){
			try {
				Field field = new Field();
				field.setKey(key);
				field.setValue(object.get(key).toString());
				data.add(field);
			} catch(Exception e){
				
			}
		}
		return data;
	}
}
