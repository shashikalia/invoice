package com.acme.dBManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum EntityManagerInstance {
	INSTANCE;
	private EntityManagerFactory  emFactory;
	private EntityManagerInstance() {
		/* "acmeJPAHandler" was the value of the name attribute of the Persistence.xml file */
		emFactory = Persistence.createEntityManagerFactory("acmeJPAHandler");
	}
	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
	public void close() {
		emFactory.close();
	}
}
