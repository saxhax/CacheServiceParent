package com.unsa.pmf.ws.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.exception.CacheAlreadyExistException;
import com.unsa.pmf.ws.common.exception.CacheNotExistException;
import com.unsa.pmf.ws.common.exception.SessionNotValidException;
import com.unsa.pmf.ws.common.filter.Condition;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.data.Field;
import com.unsa.pmf.ws.common.data.Row;
import com.unsa.pmf.ws.common.session.SessionFactory;
import com.unsa.pmf.ws.dal.Dal;

public class CoreService {
	private static Map<String, Session> activeSessions = null;
	private static Map<String, List<Row>> cache = null;
	
	public static void main(String[] args) throws Exception {
		CoreService service = new CoreService();
		Filter filter = new Filter();
		Field field = new Field("key", "value");
		filter.getFindFields().add(field);
		filter.setCondition(new Condition());
		Session session = new Session();
		session.setSessionId("75d07094-3407-4eaa-8918-4253f47733c6");
		session.setSessionName("ake");
		service.getValues(session, filter);
	}
	
	public CoreService() throws Exception{
		if (activeSessions == null) {
			activeSessions = new Dal().getSessions();
		}
		if (cache == null) {
			cache = new HashMap<String, List<Row>>();
			Dal dal = new Dal();
			for (String collectionName : activeSessions.keySet()) {
				cache.put(collectionName, dal.getAll(collectionName));
			}
		}
	}
	/**
	 * Create cache
	 * @param configurations
	 * @return
	 * @throws CacheAlreadyExistException 
	 */
	public Session createCacheService(Configurations configurations) throws CacheAlreadyExistException{
		if (activeSessions.containsKey(configurations.getName())) {
			throw new CacheAlreadyExistException();
		}
		Session session = null;
		try {
			session = SessionFactory.getSession(configurations.getName());
			Dal dal = new Dal();
			dal.createCacheService(configurations.getName());
			dal.storeSession(session);
			activeSessions.put(session.getSessionName(), session);
			cache.put(session.getSessionName(), new ArrayList<Row>());
		} catch (Exception e) {
			return null;
		}
		return session;
	}
	
	/**
	 * Get session for cache service 
	 * @param name
	 * @return
	 * @throws CacheNotExistException 
	 */
	public Session getCacheService(String name) throws CacheNotExistException{
		if (activeSessions.containsKey(name)) {
			return activeSessions.get(name);
		} else {
			throw new CacheNotExistException();
		}
	}

	/**
	 * Put values
	 * @param session
	 * @param values
	 * @return
	 * @throws Exception 
	 */
	public Session putValues(Session session, List<Field> values) throws Exception {
		if (activeSessions.containsKey(session.getSessionName())) {
			String id = activeSessions.get(session.getSessionName()).getSessionId();
			if (id.equalsIgnoreCase(session.getSessionId())) {
				Dal dal = new Dal();
				dal.put(values, session.getSessionName());
				cache.get(session.getSessionName()).add(new Row(values));
				return session;
			} else {
				throw new SessionNotValidException();
			}
		} else {
			throw new SessionNotValidException();
		}
	}

	/**
	 * Get values
	 * @param session
	 * @param filter
	 * @return
	 * @throws Exception 
	 */
	public Data getValues(Session session, Filter filter) throws Exception{
		if (activeSessions.containsKey(session.getSessionName())) {
			String id = activeSessions.get(session.getSessionName()).getSessionId();
			if (id.equalsIgnoreCase(session.getSessionId())) {
				Dal dal = new Dal();
				if (filter != null && filter.getCondition() != null && filter.getCondition().getUseCache()) {
					return generateData(filter, session.getSessionName());
				}
				return dal.get(filter, session.getSessionName());
			} else {
				throw new SessionNotValidException();
			}
		} else {
			throw new SessionNotValidException();
		}
	}
	
	/**
	 * Close session
	 * @param session
	 */
	public void closeSession(Session session) throws Exception{
		if (activeSessions.containsKey(session.getSessionName())) {
			Dal dal = new Dal();
			dal.removeSession(session);
			session.setSessionId(UUID.randomUUID().toString());
			dal.storeSession(session);
			activeSessions.remove(session.getSessionName());
			activeSessions.put(session.getSessionName(), session);
		}
	}

	/**
	 * Generate data
	 * @param filter
	 */
	private Data generateData(Filter filter, String sessionName) {
		Data data = new Data();
		List<Row> rows = cache.get(sessionName);
		for (Row row : rows) {
			if (isAppropriateRow(row, filter)) {
				data.getFoundRows().add(row);
			}
		}
		return data;
	}
	
	/**
	 * Check is row part of filter
	 * @param row
	 * @param filter
	 * @return
	 */
	private boolean isAppropriateRow(Row row, Filter filter) {
		for (Field field : row.getFields()) {
			for (Field find : filter.getFindFields()) {
				if (find != null) {
					if (field != null) {
						if (field.getKey() != null && find.getKey() != null) {
							if (field.getValue() != null && find.getValue() != null) {
								if (field.getKey().equals(find.getKey())) {
									if (field.getValue().equals(find.getValue())) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
