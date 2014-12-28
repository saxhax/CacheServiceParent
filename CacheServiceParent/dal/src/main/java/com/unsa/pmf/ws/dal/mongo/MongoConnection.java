package com.unsa.pmf.ws.dal.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoConnection {
	
	/**
	 * Store data to database
	 * @param data
	 * @throws UnknownHostException 
	 */
	public void storeData(Map<String, String> data, String collectionName) throws UnknownHostException{
		BasicDBObject object = new BasicDBObject();
		for(String key : data.keySet()){
			object.put(key, data.get(key));
		}
		store(object, collectionName);
	}
	
	/**
	 * Remove object
	 * @param object
	 * @throws UnknownHostException
	 */
	public void remove(DBObject object, String collectionName) throws UnknownHostException{
		getCollection(collectionName).remove(object);
	}
	
	/**
	 * Create cache
	 * @param collectionName
	 * @throws UnknownHostException
	 */
	public void createCollection(String collectionName) throws UnknownHostException{
		getDB().createCollection(collectionName, null);
	}
	
	/**
	 * Get data
	 * @param object
	 * @param collectionName
	 * @throws UnknownHostException 
	 */
	public List<DBObject> get(BasicDBObject object, String collectionName) throws UnknownHostException{
		List<DBObject> data = new ArrayList<DBObject>();
		DBCursor cursor = getCollection(collectionName).find(object);
		while(cursor.hasNext()){
			data.add(cursor.next());
		}
		return data;
	}
	
	/**
	 * Store one object
	 * @param object
	 * @throws UnknownHostException 
	 */
	private void store(BasicDBObject object, String collectionName) throws UnknownHostException{
		getCollection(collectionName).insert(object);
	}
	
	/**
	 * Mongo collection
	 * @param collectionName
	 * @return
	 * @throws UnknownHostException
	 */
	private DBCollection getCollection(String collectionName) throws UnknownHostException{
		DB db = getDB();
		DBCollection collection = db.getCollection(collectionName);
		return collection;
	}
	
	/**
	 * Mongo database
	 * @return
	 * @throws UnknownHostException
	 */
	private DB getDB() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		return mongoClient.getDB( "mydb" );
	}
}
