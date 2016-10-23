package com.acme.dBManager;

import java.util.List;

import com.acme.model.CustomerInvoice;

public class DBOperation {

	public String QueryExecutor(String queryString) {

		EntityManagerImpl entityManagerImpObj = new EntityManagerImpl();
		entityManagerImpObj.beginTransaction();
		entityManagerImpObj.createQuery(queryString);
		List<?> list = entityManagerImpObj.getList();

		ObjectWriterImpl objImp = new ObjectWriterImpl();
		String jsonResponse = objImp.getJsonFromList(list);
		entityManagerImpObj.closeEntityManager();

		return jsonResponse;
	}

	public String persistData(CustomerInvoice data) {
		EntityManagerImpl entityManagerImpObj = new EntityManagerImpl();
		entityManagerImpObj.beginTransaction();
		entityManagerImpObj.persistData(data);
		entityManagerImpObj.commit();
		CustomerInvoice cust = entityManagerImpObj.getEntityManager().find( CustomerInvoice.class, data.getInvoiceId());
		;
		ObjectWriterImpl objImp = new ObjectWriterImpl();
		String jsonResponse = objImp.getJsonFromObject(cust);
		entityManagerImpObj.closeEntityManager();
		return jsonResponse;
	}
}
