package com.acme.invoice.Service;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.acme.model.CustomerInvoiceLabel;

public class ServiceQuery {

	private Logger logger = Logger.getLogger(ServiceQuery.class);
	/**
	 * This function take queryFilters from Get request and retruns a SQL query
	 * based on the filters.
	 * 
	 * @param customerId
	 * @param month
	 * @param filter
	 * @param addressId
	 * @return String SQL Query
	 */
	public String createDBQueryFromQueryParams(String customerId, int month,
			String filter, String addressId) {

		StringBuilder sb = new StringBuilder();

		if (customerId != null && !customerId.isEmpty()) {
			sb.append(CustomerInvoiceLabel.CUSTOMERID + "=" + customerId);
		}
		if (month != 0) {
			String monthFilter = buildMonthBasedFilter(month);
			sb.append(monthFilter);
		}
		if (filter != null && !filter.isEmpty()) {
			sb.append(";" + CustomerInvoiceLabel.INVOICETYPE + "= '"
					+ CustomerInvoiceLabel.purchaseTypeMap.get(filter) +"'");
		}
		if (addressId != null && !addressId.isEmpty()) {
			sb.append(";" + CustomerInvoiceLabel.ADDRESSID + "= '" + addressId +"'");
		}

		return getFinalQuery(sb);
	}

	/**
	 * 
	 * @param Function receive the StringBuilder object with tokenized filters
	 * and return a fully qualified SQL query
	 * @return String SQLQuery
	 */
	private String getFinalQuery(StringBuilder sb) {
		boolean isFirstParam = true;
		StringBuilder finalQuery = new StringBuilder();
		finalQuery.append("SELECT c FROM CustomerInvoice c");
		if (!sb.toString().isEmpty()) {
			String[] queryParams = sb.toString().split(";");

			for (String param : queryParams) {
				if (!param.isEmpty()) {
					if (isFirstParam == true) {
						finalQuery.append(" WHERE " + param);
						isFirstParam = false;
					} else {
						finalQuery.append(" AND " + param);
					}
				}
			}
		}
		logger.debug("Final Query to dataBase: "+finalQuery.toString());
		return finalQuery.toString();
	}

	/**
	 * This function return the part of database query for month based selection
	 * considering the previous month invoice details
	 * @param month
	 * @return String MonthQuery
	 */
	private String buildMonthBasedFilter(int month) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		/* Calculating the previous month from Database */
		if (month == 1) {
			return ";MONTH(" + CustomerInvoiceLabel.INVOICEDATE + ")=12 "
					+ "AND YEAR(" + CustomerInvoiceLabel.INVOICEDATE + ")="
					+ (year - 1);
		} else {
			return ";MONTH(" + CustomerInvoiceLabel.INVOICEDATE + ")="
					+ (month - 1) + " " + "AND YEAR("
					+ CustomerInvoiceLabel.INVOICEDATE + ")=" + year;
		}
	}
}
