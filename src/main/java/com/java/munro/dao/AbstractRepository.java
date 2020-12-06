package com.java.munro.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AbstractRepository {

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("deprecation")
	protected Criteria createCriteria(final Class<?> persistenceClass) {
		return em.unwrap(Session.class).createCriteria(persistenceClass);
	}
	
}
