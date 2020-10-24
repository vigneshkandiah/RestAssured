package Chaining;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithBody extends BaseRequest {
	@Test
	
	public void createIncident() {
		Response response= request
		
				.body("{\"short_description\" : \"My New Incident\",\"category\":\"Hardware\"}")
				
				.post();
		int statusCode = response.getStatusCode();
		
		JsonPath jsonPath = response.jsonPath();
		
		sys_id = jsonPath.get("result.sys_id");
		
		System.out.println(sys_id);
		
		System.out.println(statusCode);
	}

}
