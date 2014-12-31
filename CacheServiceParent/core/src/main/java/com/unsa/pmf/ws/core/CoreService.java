package com.unsa.pmf.ws.core;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.exception.CacheAlreadyExistException;
import com.unsa.pmf.ws.common.exception.CacheNotExistException;
import com.unsa.pmf.ws.common.exception.SessionNotValidException;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.data.Set;
import com.unsa.pmf.ws.common.session.SessionFactory;
import com.unsa.pmf.ws.dal.Dal;

public class CoreService {
	private static Map<String, Session> activeSessions = null;
	
	public CoreService(){
		if (activeSessions == null){
			activeSessions = new Dal().getSessions();
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
	public Session putValues(Session session, List<Set> values) throws Exception {
		if (activeSessions.containsKey(session.getSessionName())) {
			String id = activeSessions.get(session.getSessionName()).getSessionId();
			if (id.equalsIgnoreCase(session.getSessionId())) {
				Dal dal = new Dal();
				dal.put(values, session.getSessionName());
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
}
