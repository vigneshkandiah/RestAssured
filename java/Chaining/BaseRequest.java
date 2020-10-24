package Chaining;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	public static String sys_id;
	public static RequestSpecification request;
    @BeforeSuite
	public void initialize() {
		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";

		RestAssured.authentication=RestAssured.basic("admin", "Password@1");

		 request = RestAssured
				//				.given().contentType("application/json")
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON);


	}

}
