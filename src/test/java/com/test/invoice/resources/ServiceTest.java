package com.test.invoice.resources;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.acme.invoice.resources.Service;
import com.acme.model.CustomerInvoice;
import com.google.gson.Gson;

public class ServiceTest {

	@Test
	/**
	 * Invoices per month
	 */
	public void getInvoices_test1() {
		Service service = new Service();
		String response = service.getInvoices("1", 3, null, null);
		
		Gson gson = new Gson();
		CustomerInvoice[] data1 = gson.fromJson(response, CustomerInvoice[].class);
		boolean test=true;
		for(CustomerInvoice c:data1) {
			Date d = c.getInvoiceDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			if(c.getCustomerId().equals("1") && cal.get(Calendar.MONTH)==Calendar.FEBRUARY) {
				continue;
			} else {
				test=false;
				break;
			}
		}
		assertTrue(test);
	}
	
	/**
	 * Shop Invoices
	 */
	@Test
	public void getInvoices_test2() {
		Service service = new Service();
		String response = service.getInvoices("1", 3, "shop", null);
		
		Gson gson = new Gson();
		CustomerInvoice[] data1 = gson.fromJson(response, CustomerInvoice[].class);
		boolean test=true;
		for(CustomerInvoice c:data1) {
			Date d = c.getInvoiceDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			if(c.getCustomerId().equals("1") && cal.get(Calendar.MONTH)==Calendar.FEBRUARY) {
				continue;
			} else {
				test=false;
				break;
			}
		}
		assertTrue(test);
	}
	
	/**
	 * Invoices history per address
	 */
	@Test
	public void getInvoices_test3() {
		Service service = new Service();
		String response = service.getInvoices("1", 0, null, "8212BJ154");
		
		Gson gson = new Gson();
		CustomerInvoice[] data1 = gson.fromJson(response, CustomerInvoice[].class);
		boolean test=true;
		for(CustomerInvoice c:data1) {
			if(c.getCustomerId().equals("1") && c.getAddressId().equals("8212BJ154")) {
				continue;
			} else {
				test=false;
				break;
			}
		}
		assertTrue(test);
	}
	
	/**
	 * Invoices history full
	 */
	@Test
	public void getInvoices_test4() {
		Service service = new Service();
		String response = service.getInvoices("1", 0, null, null);
		
		Gson gson = new Gson();
		CustomerInvoice[] data1 = gson.fromJson(response, CustomerInvoice[].class);
		boolean test=true;
		for(CustomerInvoice c:data1) {
			if(c.getCustomerId().equals("1")) {
				continue;
			} else {
				test=false;
				break;
			}
		}
		assertTrue(test);
	}
	
}
