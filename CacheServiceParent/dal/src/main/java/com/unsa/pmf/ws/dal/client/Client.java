package com.unsa.pmf.ws.dal.client;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.unsa.pmf.ws.dal.entity.Session;

public class Client {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("dal");
	private static EntityManager manager = factory.createEntityManager();
	private static EntityTransaction tx = manager.getTransaction();
	
	public void storeSession(Session session){
		tx.begin();
    	manager.persist(session);
        tx.commit();
	}
	
	public void removeSession(Session session){
		tx.begin();
    	manager.remove(session);
        tx.commit();
	}
	
	public static void main(String[] args) {
		System.out.println(new Date());
		Client client = new Client();
		for (int i = 0; i < 1000; i++){
			Session session = new Session();
			session.setName("name");
			client.storeSession(session);
		}
		System.out.println(new Date());
	}
}
