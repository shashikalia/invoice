package com.acme.dBManager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.acme.model.CustomerInvoice;

public class ObjectWriterImpl {
	
	private Logger logger = Logger.getLogger(ObjectWriterImpl.class);
	private ObjectWriter objectWriter;
	
	public ObjectWriterImpl() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		ObjectMapper mapper= new ObjectMapper();
		mapper.setDateFormat(df);
		objectWriter = mapper.writer().withDefaultPrettyPrinter();
	}

	public String getJsonFromList(List<?> list) {
		
		StringBuilder sb = new StringBuilder();
		boolean firstRecord = true;
		@SuppressWarnings("unchecked")
		List<CustomerInvoice> list1 = (List<CustomerInvoice>) list;
		sb.append("[");
		for(CustomerInvoice cust:list1) {
			if(firstRecord) {
				firstRecord=false;
			} else {
				sb.append(",");
			}
			sb.append(getJsonFromObject(cust));
		}
		sb.append("]");
		if(logger.isDebugEnabled()) {
			logger.debug(sb.toString());
		}
		return sb.toString();
	}
	
	public String getJsonFromObject(CustomerInvoice cust) {
		String response ="";
		try {
			response = objectWriter.writeValueAsString(cust);
		} catch (JsonGenerationException e) {
			logger.error(e,e);
		} catch (JsonMappingException e) {
			logger.error(e,e);
		} catch (IOException e) {
			logger.error(e,e);
		}
		return response;
	}
}
