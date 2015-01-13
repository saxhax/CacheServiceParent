package com.unsa.pmf.ws.dal.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.unsa.pmf.ws.common.data.Field;
import com.unsa.pmf.ws.common.filter.Condition;

public class MongoConnection {
	private static final String DEFAULT_DB = "cache"; 
	private static MongoClient mongoClient;
	
	/**
	 * Store data to database
	 * @param data
	 * @throws UnknownHostException 
	 */
	public void storeData(List<Field> data, String collectionName) throws UnknownHostException{
		BasicDBObject object = new BasicDBObject();
		for(Field field : data){
			object.put(field.getKey(), field.getValue());
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
	public List<DBObject> get(BasicDBObject object, String collectionName, Condition condition) throws UnknownHostException{
		List<DBObject> data = new ArrayList<DBObject>();
		condition = condition == null ? new Condition() : condition;
		DBCursor cursor;
		if (condition.getLimit() == null || condition.getLimit() < 0) {
			cursor = getCollection(collectionName).find(object);
		} else {
			cursor = getCollection(collectionName).find(object).limit(condition.getLimit());
		}
		while(cursor.hasNext()){
			data.add(cursor.next());
		}
		return data;
	}
	
	/**
	 * Find All
	 * @param collectionName
	 * @return
	 * @throws UnknownHostException
	 */
	public List<DBObject> getAll(String collectionName) throws UnknownHostException{
		List<DBObject> data = new ArrayList<DBObject>();
		DBCursor cursor;
		cursor = getCollection(collectionName).find();

		while(cursor.hasNext()){
			data.add(cursor.next());
		}
		return data;
	}
	
	/** Delete Collection
	 * @param name
	 * @throws UnknownHostException
	 */
	public void dropCollection(String name) throws UnknownHostException{
		DB db = getDB();
		db.getCollection(name).drop();
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
		try {
			if (mongoClient != null && !mongoClient.isLocked()) {
				return mongoClient.getDB(DEFAULT_DB);
			} else {
				mongoClient = new MongoClient( "localhost" , 27017 );
				return mongoClient.getDB(DEFAULT_DB);
			}
		} catch (Exception e){
			mongoClient = new MongoClient( "localhost" , 27017 );
			return mongoClient.getDB(DEFAULT_DB);
		}
	}
}
