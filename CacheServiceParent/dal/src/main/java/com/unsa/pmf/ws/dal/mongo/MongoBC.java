package com.unsa.pmf.ws.dal.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mongodb.DBObject;
import com.unsa.pmf.ws.dal.map.Mapper;

public class MongoBC {
	
	/**
	 * Store data to collection
	 * @param data
	 * @throws UnknownHostException
	 */
	public void store(List<String> data, String collectionName) throws UnknownHostException{
		MongoConnection connection = new MongoConnection();
		Map<String, String> mappedData = Mapper.generateMap(data);
		connection.storeData(mappedData, collectionName);
	}

	/**
	 * Remove items from collection
	 * @param data
	 * @throws UnknownHostException
	 */
	public void remove(List<String> data, String collectionName) throws UnknownHostException{
		MongoConnection connection = new MongoConnection();
		DBObject object = Mapper.generateObject(data);
		connection.remove(object, collectionName);
	}
	
	/**
	 * Create collection
	 * @param collectionName
	 * @throws UnknownHostException
	 */
	public void createCache(String collectionName) throws UnknownHostException{
		MongoConnection connection = new MongoConnection();
		connection.createCollection(collectionName);
	}
	
	/**
	 * Get data
	 * @param data
	 * @param collectionName
	 * @return
	 * @throws UnknownHostException 
	 */
	public List<List<String>> get(List<String> data, String collectionName) throws UnknownHostException{
		List<List<String>> result = new ArrayList<List<String>>();
		List<DBObject> list = new MongoConnection().get(Mapper.generateObject(data), collectionName);
		for (DBObject object : list){
			result.add(Mapper.generateList(object));
		}
		return result;
	}
}
