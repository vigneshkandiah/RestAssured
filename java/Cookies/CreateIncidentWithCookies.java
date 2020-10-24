package Cookies;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithCookies {
	@Test
	
	public void createIncident() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";
		
//		RestAssured.authentication=
//		RestAssured.oauth2("CnlwAi2i_Cs9YNu1vYnKJdZ7wo9E8Wnh2T-BoY_1jQrAFLAtQotXhbLKUT9XaFT9-JZqgeEdcQlo-sQcw5EQoA");
		
		Response response = RestAssured
//				.given().contentType("application/json")
				.given().contentType(ContentType.JSON)
				.cookie("JSESSIONID","9F2FB551B821903183AB847CEF33E2E9")
				//.header(new Header("Authorization", "Bearer b30qNDF6TGy5qr86UBfATt7J48Aon2FVNKR-XiwnIDkZGYi2SpFg68xRZ5KrSQu23R8_87erAohxjkFMhUcbzg"))
//				.header(new Header("Accept", "application/xml"))
				.when()
				.body("{\"short_description\" : \"My New Incident\",\"category\":\"Hardware\"}")
				
				.post();
		int statusCode = response.getStatusCode();
		
		Map<String, String> allcookies = response.getCookies();
		
		for (Entry<String, String> eachCookies:allcookies.entrySet() ) {
			
			System.out.println("Name Of the Cookies :" +eachCookies.getKey()+"  The Value is:"+eachCookies.getValue());
			
		}
		
		JsonPath jsonPath = response.jsonPath();
		
		String sys_id = jsonPath.get("result.sys_id");
		
		System.out.println(sys_id);
		
		System.out.println(statusCode);
	}

}
