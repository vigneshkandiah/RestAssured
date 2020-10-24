package apiBasicRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateChangeRequestWithJsonBody {
	@Test
	public void createChangeRequestwithFile() {
		
		
		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/change_request";
		RestAssured.authentication= RestAssured.basic("admin", "Password@1");
		
		
		Response response = RestAssured
//				.given().contentType("application/json")
				.given().contentType(ContentType.JSON)
				.when()
				.body("{\"short_description\":\"My New Change Request using Json Body\",\"type\":\"normal\"}")
				
				.post();
		
		int statusCode = response.getStatusCode();
		
		System.out.println(statusCode);
		
		JsonPath jsonPath = response.jsonPath();
		
		Object object = jsonPath.get("result.number");
		
		System.out.println(object);
		
		
	}

}
