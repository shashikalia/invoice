package com.test.dBManager;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.acme.dBManager.DBOperation;
import com.acme.model.CustomerInvoice;
import com.google.gson.Gson;

public class DBOperationTest {

	@Test
	/* Insert database query */
	public void persistData_test() throws JsonParseException, JsonMappingException, IOException {
		Date date = new Date();
		CustomerInvoice data = new CustomerInvoice("99", "8212BJ154", 
				"70ec3a54a499994aa9e8","AdvancePayment", "Voorschot", date,
				date, "157005888", date,
				date, "Maart 2015",165.29,34.71,200);
		
		DBOperation dbOperation = new DBOperation();
		String response = dbOperation.persistData(data);
		System.out.println(response);
		ObjectMapper mapper = new ObjectMapper();
		CustomerInvoice data1 = mapper.readValue(response, CustomerInvoice.class);
		assertTrue(data.getInvoiceId().equals(data1.getInvoiceId()));
	}
	
	@Test
	/* Test to select all invoices from database ensuring database should be populated */
	public void QueryExecutor_test1() {
		DBOperation dbOperation = new DBOperation();
		String response = dbOperation.QueryExecutor("Select c from CustomerInvoice c");
		Gson gson = new Gson();
		CustomerInvoice[] data1 = gson.fromJson(response, CustomerInvoice[].class);
		assertTrue(data1.length!=0);
	}
	
	@Test
	/* Test to select all invoices from database ensuring database should be populated */
	public void QueryExecutor_test2() {
		DBOperation dbOperation = new DBOperation();
		String response = dbOperation.QueryExecutor("Select c from CustomerInvoice c WHERE customerId='99'");
		Gson gson = new Gson();
		CustomerInvoice[] data1 = gson.fromJson(response, CustomerInvoice[].class);
		boolean test=true;
		for(CustomerInvoice c:data1) {
			if(c.getCustomerId().equals("99")) {
				continue;
			} else {
				test=false;
				break;
			}
		}
		assertTrue(test);
	}
	
	@Test
	/**
	 * Invoices per month
	 */
	public void QueryExecutor_test3() {
		DBOperation dbOperation = new DBOperation();
		String response = dbOperation.QueryExecutor("Select c from CustomerInvoice c WHERE customerId='99'"
				+ " and MONTH(invoiceDate)=11 and YEAR(invoiceDate)=2016");
		Gson gson = new Gson();
		CustomerInvoice[] data1 = gson.fromJson(response, CustomerInvoice[].class);
		boolean test=true;
		for(CustomerInvoice c:data1) {
			Date d = c.getInvoiceDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			if(c.getCustomerId().equals("99") && cal.get(Calendar.MONTH)==Calendar.OCTOBER) {
				continue;
			} else {
				test=false;
				break;
			}
		}
		assertTrue(test);
	}
	
}
