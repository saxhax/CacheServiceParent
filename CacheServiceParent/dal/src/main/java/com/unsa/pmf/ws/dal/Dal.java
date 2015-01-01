package com.unsa.pmf.ws.dal;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.data.Row;
import com.unsa.pmf.ws.common.data.Field;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.dal.client.Client;
import com.unsa.pmf.ws.dal.map.Mapper;
import com.unsa.pmf.ws.dal.mongo.MongoBC;

public class Dal {
	
	private Client client = new Client();
	
	/**
	 * Sessions
	 * @return
	 */
	public Map<String, Session> getSessions(){
		return client.getAllSessions();
	}
	
	/**
	 * Store session
	 * @param session
	 */
	public void storeSession(Session session){
		client.store(Mapper.getSession(session));
	}
	
	/**
	 * Remove session
	 * @param session
	 */
	public void removeSession(Session session){
		client.remove(Mapper.getSession(session));
	}
	
	/**
	 * Create cache
	 * @param name
	 * @throws UnknownHostException
	 */
	public void createCacheService(String name) throws UnknownHostException{
		MongoBC bc = new MongoBC();
		bc.createCache(name);
	}
	
	/**
	 * Put values to collection
	 * @param collectionName
	 * @param values
	 * @throws IOException 
	 */
	public void put(List<Field> values, String collectionName) throws Exception{
		MongoBC bc = new MongoBC();
		bc.store(values, collectionName);
	}
	
	/**
	 * Get values
	 * @param values
	 * @param collectionName
	 * @throws Exception
	 */
	public Data get(Filter filter, String collectionName) throws Exception{
		MongoBC bc = new MongoBC();
		List<List<Field>> listData = bc.get(filter, collectionName);
		Data data = new Data();
		for (List<Field> list : listData) {
			Row row = new Row();
			row.setFields(list);
			data.getFoundRows().add(row);
		}
		return data;
	}
}
