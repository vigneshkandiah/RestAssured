package apiBasicRequest;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateIncidentusingPatch {
	@Test
	
	public void updateIncident() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";
		
		RestAssured.authentication=RestAssured.basic("admin", "Password@1");
		
		Response response = RestAssured
//				.given().contentType("application/json")
				.given().contentType(ContentType.JSON)
				.when()
				.body("{\"short_description\" : \"My New Incident”,\"category\":\"Hardware\"}")
				.accept(ContentType.JSON)
				.pathParam("sys_id", "b7025f14db175010262917803996197e")
				
				.patch("{sys_id}");
		int statusCode = response.getStatusCode();
		
		JsonPath jsonPath = response.jsonPath();
		
		String short_description = jsonPath.get("result.short_description");
		
		System.out.println(short_description);
		
		System.out.println(statusCode);
	}

}
