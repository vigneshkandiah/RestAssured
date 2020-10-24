package apiBasicRequest;

import java.io.File;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithJsonFile {
	@Test
	
	public void createIncident() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";
		
		RestAssured.authentication=RestAssured.basic("admin", "Password@1");
		File jsonFile = new File("./CreateIncident.json");
		Response response = RestAssured
//				.given().contentType("application/json")
				.given().contentType(ContentType.JSON)
				.when()
				.body(jsonFile)
				
				.post();
		int statusCode = response.getStatusCode();
		
		JsonPath jsonPath = response.jsonPath();
		
		String sys_id = jsonPath.get("result.short_description");
		
		System.out.println(sys_id);
		
		System.out.println(statusCode);
	}

}
