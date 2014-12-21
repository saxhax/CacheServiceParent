package com.unsa.pmf.ws.dal.map;

import com.unsa.pmf.ws.common.session.Session;

public class Mapper {

	public static Session getSession(com.unsa.pmf.ws.dal.entity.Session entity) {
		Session session = new Session();
		session.setSessionId(entity.getId());
		session.setSessionName(entity.getName());
		return session;
	}

	public static com.unsa.pmf.ws.dal.entity.Session getSession(Session session) {
		com.unsa.pmf.ws.dal.entity.Session entity = new com.unsa.pmf.ws.dal.entity.Session();
		entity.setId(session.getSessionId());
		entity.setName(session.getSessionName());
		return entity;
	}
}
