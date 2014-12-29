package com.unsa.pmf.ws.core;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.unsa.pmf.ws.common.session.Session;
import com.unsa.pmf.ws.common.config.Configurations;
import com.unsa.pmf.ws.common.filter.Filter;
import com.unsa.pmf.ws.common.data.Data;
import com.unsa.pmf.ws.common.session.SessionFactory;
import com.unsa.pmf.ws.dal.Dal;

public class CoreService {

	/**
	 * Create cache
	 * @param configurations
	 * @return
	 */
	public Session createCacheService(Configurations configurations){
		Session session = null;
		try {
			session = SessionFactory.getSession(configurations.getName());
			Dal dal = new Dal();
			dal.createCacheService(configurations.getName());
			dal.storeSession(session);
		} catch (Exception e) {
			return null;
		}
		return session;
	}
	
	/**
	 * Get session for cache service 
	 * @param name
	 * @return
	 */
	public Session getCacheService(String name){
		return SessionFactory.getSession(name);
	}

	/**
	 * Put values
	 * @param session
	 * @param values
	 * @return
	 */
	public Session putValues(Session session, List<String> values) {
		try {
			Dal dal = new Dal();
			dal.put(values, session.getSessionName());
		} catch (Exception e) {
			return null;
		}
		return session;
	}

	/**
	 * Get values
	 * @param session
	 * @param filter
	 * @return
	 */
	public Data getValues(Session session, Filter filter){
		try {
			Dal dal = new Dal();
			return dal.get(filter, session.getSessionName());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Close session
	 * @param session
	 */
	public void closeSession(Session session) {
		Dal dal = new Dal();
		dal.removeSession(session);
	}
	
	public static void main(String[] args) throws UnknownHostException {
		CoreService service = new CoreService();
		Session session = new Session();
		session.setSessionName("testNameNew2");
		List<String> values = new ArrayList<String>();
		values.add("one");
		values.add("two");
		values.add("three");
		service.putValues(session, values);
		Filter filter = new Filter();
		Data data = service.getValues(session, filter);
		System.out.println(data.getSpecificValues());
	}
}
