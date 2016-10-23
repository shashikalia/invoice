
package com.acme.invoice.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.acme.dBManager.DBOperation;
import com.acme.invoice.Service.ServiceQuery;
import com.acme.model.CustomerInvoice;

@Path("/invoices")
public class Service {
	
	private Logger logger = Logger.getLogger(Service.class);
	
    /** Method processing HTTP GET requests, producing "Json" MIME media
     * type.
     * @return String that will be send back as a response of type "Json".
     */
    @GET 
    @Produces({MediaType.APPLICATION_JSON})
    public String getInvoices(@QueryParam("customerId") String customerId,
    							@QueryParam("month") int month,
    							@QueryParam("filter") String filter,
    							@QueryParam("addressId") String addressId) {
    	
    	if(logger.isDebugEnabled()) {
    		logger.debug("Query Param Received: CustomerId"+customerId+"; Month:"+month
    				+"; Filter:"+filter+"; AddressId:"+addressId);
    	}
    	logger.info("Service Request Received");
    	/* Creating Query based on received filters to fetch invoices from databases */
    	ServiceQuery serviceQuery = new ServiceQuery();
    	String Query = serviceQuery.createDBQueryFromQueryParams(customerId, month, filter, addressId);
    	
    	DBOperation dbOperation = new DBOperation();
    	return dbOperation.QueryExecutor(Query);
    }	
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String createInvoices(CustomerInvoice data) {
    	logger.debug("Handling Post Request"+data.toString());
    	DBOperation dbOperation = new DBOperation();
    	return dbOperation.persistData(data);
    }
    
    static
	{
		PropertyConfigurator.configureAndWatch(Service.class.getResource("/log4j.xml").getFile(), 5000L);
	}
}
