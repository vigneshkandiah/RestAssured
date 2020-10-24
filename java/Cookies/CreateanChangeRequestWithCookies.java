package Cookies;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateanChangeRequestWithCookies {


	@Test
	public void createChangeRequestwithCookie() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/v2/table/change_request";
		//RestAssured.authentication=RestAssured.basic("admin", "Password@1");

		Response response = RestAssured
				//				.given().contentType("application/json")
				.given().contentType(ContentType.JSON)
				.cookie("JSESSIONID","0AE664FB17B158E13B5CF1B7CF2FE45E")
				//.header(new Header("Authorization", "Bearer b30qNDF6TGy5qr86UBfATt7J48Aon2FVNKR-XiwnIDkZGYi2SpFg68xRZ5KrSQu23R8_87erAohxjkFMhUcbzg"))
				//				.header(new Header("Accept", "application/xml"))
				.when()
				.body("{\"short_description\":\"My New Change Request using Json Body\",\"type\":\"normal\"}")

				.post();

		Map<String, String> cookies = response.getCookies();

		for (Entry<String, String> each : cookies.entrySet()) {

			System.out.println(each.getKey()+"-------------------"+each.getValue());

		}


		JsonPath path = response.jsonPath();

		Object object = path.get("result.number");

		System.out.println(object);


		int statusCode = response.getStatusCode();

		System.out.println(statusCode);





	}

}
