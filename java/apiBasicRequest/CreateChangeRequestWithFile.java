package apiBasicRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateChangeRequestWithFile {
	@Test
	public void createChangeRequestwithFile() {
		
		File jsonFile = new File("./CreateChangeRequest.json");
		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/change_request";
		RestAssured.authentication= RestAssured.basic("admin", "Password@1");
		
		
		Response response = RestAssured
//				.given().contentType("application/json")
				.given().contentType(ContentType.JSON)
				.when()
				.body(jsonFile)
				
				.post();
		
		int statusCode = response.getStatusCode();
		
		System.out.println(statusCode);
		
		JsonPath jsonPath = response.jsonPath();
		
		Object object = jsonPath.get("result.number");
		
		System.out.println(object);
		
		
	}

}
