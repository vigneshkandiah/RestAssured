package apiBasicRequest;

import java.util.List;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllChangeRequests {
	@Test
	@Parameter()
	public void getAllChangeRequests() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/change_request";

		RestAssured.authentication=RestAssured.basic("admin", "Password@1");

		Response response = RestAssured.get();
		int statusCode = response.getStatusCode();


		JsonPath jsonPath = response.jsonPath();

		List<Object> list = jsonPath.getList("result.number");

		for (Object each : list) {

			System.out.println(each);

		}
		System.out.println(statusCode);
	}

}
