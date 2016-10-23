package com.acme.dBManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.acme.model.CustomerInvoice;

public class EntityManagerImpl {
	
	private EntityManager entitymanager;
	private Query query;
	
	public EntityManagerImpl() {
		entitymanager = EntityManagerInstance.INSTANCE.getEntityManager();
	}

	public EntityManager getEntityManager() {
		return entitymanager;
	}
	
	public void beginTransaction() {
		entitymanager.getTransaction().begin();
	}
	
	public void createQuery(String queryString) {
		if(entitymanager != null) {
			query = entitymanager.createQuery(queryString);
		}
	}
	
	public void persistData(CustomerInvoice data) {
		entitymanager.persist(data);
	}
	
	public void commit() {
		entitymanager.getTransaction().commit();
	}
	public List<?> getList() {
		if(query != null) {
			return query.getResultList();
		}
		return null;
	}
	public void closeEntityManager() {
		entitymanager.close();
	}

}
