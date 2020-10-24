package apiBasicRequest;

import java.util.List;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident {
	@Test
	@Parameter()
	public void deleteIncident() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident/727d0bd0db1750102629178039961962";

		RestAssured.authentication=RestAssured.basic("admin", "Password@1");

		Response response = RestAssured
				.given()
				.log()
				.all()
//				.pathParam("ID", "727d0bd0db1750102629178039961962")
//				.delete("{ID");
				.delete();
		int statusCode = response.getStatusCode();


		

		
		System.out.println(statusCode);
	}

}
