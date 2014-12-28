package com.unsa.pmf.ws.dal;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.dal.client.Client;
import com.unsa.pmf.ws.dal.map.Mapper;
import com.unsa.pmf.ws.dal.mongo.MongoBC;

public class Dal {
	
	private Client client = new Client();
	
	/**
	 * Store session
	 * @param session
	 */
	public void storeSession(Session session){
		client.storeSession(Mapper.getSession(session));
	}
	
	/**
	 * Remove session
	 * @param session
	 */
	public void removeSession(Session session){
		client.removeSession(Mapper.getSession(session));
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
	public void put(List<String> values, String collectionName) throws Exception{
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
		return new Data(bc.get(filter.getData(), collectionName));
	}
}
