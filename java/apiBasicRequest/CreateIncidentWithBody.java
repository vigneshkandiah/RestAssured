package apiBasicRequest;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithBody {
	@Test
	
	public void createIncident() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";
		
//		RestAssured.authentication=
//		RestAssured.oauth2("CnlwAi2i_Cs9YNu1vYnKJdZ7wo9E8Wnh2T-BoY_1jQrAFLAtQotXhbLKUT9XaFT9-JZqgeEdcQlo-sQcw5EQoA");
		
		Response response = RestAssured
//				.given().contentType("application/json")
				.given().contentType(ContentType.JSON)
				.header(new Header("Authorization", "Bearer CnlwAi2i_Cs9YNu1vYnKJdZ7wo9E8Wnh2T-BoY_1jQrAFLAtQotXhbLKUT9XaFT9-JZqgeEdcQlo-sQcw5EQoA"))
//				.header(new Header("Accept", "application/xml"))
				.when()
				.body("{\"short_description\" : \"My New Incident\",\"category\":\"Hardware\"}")
				
				.post();
		int statusCode = response.getStatusCode();
		
		JsonPath jsonPath = response.jsonPath();
		
		String sys_id = jsonPath.get("result.sys_id");
		
		System.out.println(sys_id);
		
		System.out.println(statusCode);
	}

}
