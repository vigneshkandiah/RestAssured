package Chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateIncident extends BaseRequest{
	@Test (dependsOnMethods ="Chaining.CreateIncidentWithBody.createIncident")
	public void updateIncident() {
		Response response= request
//				
				.body("{\"short_description\" : \"My Update Incident”,\"category\":\"Hardware\"}")
				.accept(ContentType.JSON)
				.pathParam("sys_id", sys_id)
				
				.put("{sys_id}");
		int statusCode = response.getStatusCode();
		
		JsonPath jsonPath = response.jsonPath();
		
		String short_description = jsonPath.get("result.short_description");
		
		System.out.println(statusCode+"-----------"+short_description);
	}
	}
	

