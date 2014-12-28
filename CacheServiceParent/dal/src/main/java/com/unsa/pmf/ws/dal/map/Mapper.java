package com.unsa.pmf.ws.dal.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.unsa.pmf.ws.common.session.Session;

public class Mapper {
	public static final String PREFIX = "key_";
	
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
	public static BasicDBObject generateObject(List<String> data){
		BasicDBObject object = new BasicDBObject();
		int i = 0;
		if (data != null && !data.isEmpty()){
			for(String value : data){
				object.put(PREFIX + i, value);
				i++;
			}
		}
		return object;
	}
	
	/**
	 * Create map
	 * @param data
	 * @return
	 */
	public static Map<String, String> generateMap(List<String> data){
		Map<String, String> mappedData = new HashMap<String, String>();
		int i = 0;
		if (data != null && !data.isEmpty()){
			for(String value : data){
				mappedData.put(PREFIX + i, value);
				i++;
			}
		}
		return mappedData;
	}
	
	/**
	 * Create list
	 * @param data
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<String> generateList(DBObject object){
		List<String> data = new ArrayList<String>();
		for(int i = 0; i < object.keySet().size(); i++){
			try {
				if (object.containsKey(PREFIX + i)){
					data.add(object.get(PREFIX + i).toString());
				}
			} catch(Exception e){
				
			}
		}
		return data;
	}
}
