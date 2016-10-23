package com.acme.model;

import java.util.HashMap;
import java.util.Map;

public class CustomerInvoiceLabel {

	/* Database column names */
	public static final String CUSTOMERID="customerId";
	public static final String INVOICETYPE="invoiceType";
	public static final String ADDRESSID="addressId";
	public static final String INVOICEDATE="invoiceDate";
	
	/* Mapping to purchase type */
	public static Map<String,String> purchaseTypeMap = new HashMap<String,String>() { 
		
		private static final long serialVersionUID = 1L;
		{
			put("shop", "ShopPurchase");
			put("advance", "AdvancePayment");
		}
	};
}
