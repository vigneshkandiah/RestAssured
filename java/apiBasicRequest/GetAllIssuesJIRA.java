package apiBasicRequest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIssuesJIRA {
	
	@Test
	
	public void getAllIncident() {
		
		//step:1 Get the End Point or URI
		
		RestAssured.baseURI="https://vigneshkandiah.atlassian.net/rest/api/2/search";
		
		//step 2:Authentication
		
		RestAssured.authentication= RestAssured.preemptive().basic("vigneshkandiah@gmail.com","CCauMMcZ7WezBymykhg8FB4C");
		
		
		
		
		//step 3:Request type (Use get Method) Adding Parameters
		
		Response response = RestAssured.given()
				.queryParam("maxResults=1")
				.queryParam("jql", "project=AT")
				
				// HardCode
//				.queryParam("sysparm_fields", "number,type,sys_id,short_description")
//				.queryParam("sysparm_limit", "5")
				
				.get();
		
		//step 4:Validate the response Code (200 OK)
		
		System.out.println(response.getStatusCode());
		
		if (response.getStatusCode()==200) {
			System.out.println(" The Get Request is Successful");
		}else {
			
			System.out.println(" The Get Request is Not Successful");
		}
		//step 5: Validate the format
		
		String contentType = response.getContentType();
		
		if (contentType.contains("json")) {
			System.out.println(" The format is vald");
		}else {
			
			System.out.println(" The format is not valid");
		}
		
	
		
		response.prettyPrint();
		
		//step 6: Print the Response
		
		
		
		
	}

}
