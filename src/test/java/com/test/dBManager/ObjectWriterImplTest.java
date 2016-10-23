package com.test.dBManager;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.acme.dBManager.ObjectWriterImpl;
import com.acme.model.CustomerInvoice;

public class ObjectWriterImplTest {

	@Test
	public void getJsonFromObjecttest() throws JsonParseException, JsonMappingException, IOException {
		ObjectWriterImpl obj = new ObjectWriterImpl();
		Date date = new Date();
		CustomerInvoice data = new CustomerInvoice("99", "8212BJ154", 
				"70ec3a54a499994aa9e8","AdvancePayment", "Voorschot", date,
				date, "157005888", date,
				date, "Maart 2015",165.29,34.71,200);
		
		String response = obj.getJsonFromObject(data);
		
		ObjectMapper mapper = new ObjectMapper();
		CustomerInvoice data1 = mapper.readValue(response, CustomerInvoice.class);
		assertTrue(data.equals(data1));
	}

}
