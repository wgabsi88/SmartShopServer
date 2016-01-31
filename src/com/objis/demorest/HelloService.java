package com.objis.demorest;
 
import java.io.IOException;
import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;
 
@Path("/hello")
public class HelloService {
	String p;
	
	@Produces({ MediaType.APPLICATION_JSON })
	@GET
	public Response getMsg() {
 
		String output = callWS();
 
		return Response.status(200).entity(output).build();
 
	}
	
	public  String callWS()
	{
		 try {

		        ApiContext apiContext = getApiContext();	        
		       
		        GeteBayOfficialTimeCall apiCall = new GeteBayOfficialTimeCall(apiContext);
		        
		        Calendar cal = apiCall.geteBayOfficialTime();
		      
		        p = cal.getTime().toString();
		    }
		 catch(Exception e) {
		        System.out.println("Fail to get eBay official time.");
		        e.printStackTrace();
		    }
		return p;
	}
 
	
	private static ApiContext getApiContext() throws IOException {
		  
	      String inputtoken;
	      String inputsecond;
	      ApiContext apiContext = new ApiContext();
	      
	      //set Api Token to access eBay Api Server
	      ApiCredential cred = apiContext.getApiCredential();
	      inputtoken = "AgAAAA**AQAAAA**aAAAAA**TlCRVg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFk4GhDpaDpw+dj6x9nY+seQ**qqsDAA**AAMAAA**zHiIdUPHNVrMzT0y8BU3hsQGuTMoqftqSTD/3P0XVS9JVb74oCdGi7zesUE1aPu8T1bnya1h7khj6LhsyBqmtHuHMKMmoWDvanogqvJ9G7jzYp89JCZsZ96M7IdztcPMRD99ymHGVGjZ7VSO4/HnuEHuTMe7dnp6aRS0neyQ3efisuQDOTcOIWeCXpQnqMwotc9YqDqVToYSj2ZpsBHnkg5Uy4mr51S8yY4TniOQZZJQBpE12IsL1udsQG40g6m7ORfewyTOCPmc3b7P3/uF2kHOU1+hzUmbSLLB5j8bQJR++YXq3DIuJR7TwP98U5oWurESp/c03bMG71duOibeNEgqJe1TMpiCPas1yx1SmE2cH/1KjRGkPyz2Hr5RLekSblucB6wkXtm1ll8p9D1M1F9xGZVv5hUFAZtPc7U0izuQxCGh2ho5jFYEVnev6KCA0a9cJAQaC1OOhMhCdLBzPoMBOOjUggc1jobcoWwXYIiqVzrlsf6elVJEFBA8fqiguVMILaW/ODTagJRlu/0OIkT4jQLeiI/jbUCcBgs+ARhGKSotnYpqmM7ye88lqOEVJtNAw2M1Oq3l7j9YZwa1sUznPNdVhk0MvZcI+WThUhN90Q4iwFrUhQNlU4wkVWB9q8AXYYfI7Z/RE2go+ngl5XdXx5m7KN+ApJcdwVubIZeRMrYz6yglgW37lGbYwZP08s96gIOgIisz9gKZn+DKO48tzgsMbVN0Kv5FjZNA/zDFi7BhSptpsb4bQHfHfONQ";
	      cred.seteBayToken(inputtoken);
	     
	      //set Api Server Url
	      inputsecond = "https://api.sandbox.ebay.com/wsapi";
	      apiContext.setApiServerUrl(inputsecond);
	      
	      return apiContext;
	  }
}
