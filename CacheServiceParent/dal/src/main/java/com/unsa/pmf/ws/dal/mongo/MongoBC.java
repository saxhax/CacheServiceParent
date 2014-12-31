package com.unsa.pmf.ws.dal.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DBObject;
import com.unsa.pmf.ws.common.data.Set;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.dal.map.Mapper;

public class MongoBC {
	
	/**
	 * Store data to collection
	 * @param data
	 * @throws UnknownHostException
	 */
	public void store(List<Set> data, String collectionName) throws UnknownHostException{
		MongoConnection connection = new MongoConnection();
		connection.storeData(data, collectionName);
	}

	/**
	 * Remove items from collection
	 * @param data
	 * @throws UnknownHostException
	 */
	public void remove(List<Set> data, String collectionName) throws UnknownHostException{
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
	public List<List<Set>> get(Filter filter, String collectionName) throws UnknownHostException{
		List<List<Set>> result = new ArrayList<List<Set>>();
		List<DBObject> list = new MongoConnection().get(Mapper.generateObject(filter.getSpecificData()), collectionName, filter.getCondition());
		for (DBObject object : list){
			result.add(Mapper.generateList(object));
		}
		return result;
	}
}
