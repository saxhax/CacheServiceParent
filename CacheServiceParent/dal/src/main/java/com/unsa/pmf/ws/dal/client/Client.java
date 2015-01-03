package com.unsa.pmf.ws.dal.client;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.unsa.pmf.ws.dal.entity.Data;
import com.unsa.pmf.ws.dal.entity.SQLEnitiy;
import com.unsa.pmf.ws.dal.entity.Session;
import com.unsa.pmf.ws.dal.map.Mapper;

public class Client {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("dal");
	private static EntityManager manager = factory.createEntityManager();
	private static EntityTransaction tx = manager.getTransaction();
	
	/**
	 * Store entity
	 * @param entity
	 */
	public void store(SQLEnitiy entity){
		tx.begin();
    	manager.persist(entity);
        tx.commit();
	}
	
	/**
	 * Remove entity
	 * @param entity
	 */
	public void remove(String id){
		tx.begin();
		Query query = manager.createQuery("DELETE FROM Session s WHERE id='" + id + "'");
		query.executeUpdate();
        tx.commit();
	}
	
	/**
	 * All caches
	 * @return
	 */
	public Map<String, com.unsa.pmf.ws.common.session.Session> getAllSessions(){
		Map<String, com.unsa.pmf.ws.common.session.Session> sessions = new HashMap<String, com.unsa.pmf.ws.common.session.Session>();
	    Query query = manager.createQuery("SELECT s FROM Session s");
	    List<Session> storedSessions = (List<Session>) query.getResultList();
	    for (Session session : storedSessions){
	    	if (sessions.containsKey(session.getName())){
	    		remove(session.getId());
	    	} else {
	    		sessions.put(session.getName(), Mapper.getSession(session));
	    	}
	    }
	    return sessions;
	}
	
	/**
	 * Get data from database
	 * @param data
	 * @return
	 */
	public Data getData(String id){
		Data data = manager.find(Data.class, id);
		return data;
	}
	
	/**
	 * Get data from database by value
	 * @param data
	 * @return
	 */
	public List<Data> getDataByValue(String value){
		Query query = manager.createQuery("SELECT d from Data d where data_value='" + value + "'");
		return query.getResultList();
	}
	
	
	public static void main(String[] args) {
		Client client = new Client();
		Session session = new Session();
		session.setId("cc66d3d3-b7db-454d-b19a-0bfb92117517");
		client.remove(session.getId());
	}
}
