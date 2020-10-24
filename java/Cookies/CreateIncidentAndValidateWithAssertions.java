package Cookies;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateIncidentAndValidateWithAssertions {
	@Test
	
	public void createIncident() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";
		
		RestAssured.authentication=
		RestAssured.oauth2("lHulLbqX8sf39LyTXp-JTxuU4zJxVKksbnJc02PXVug85SJeEGjIQAVqzhPlO2QMxxI9uhT1JxqDO6_bSMzSSw");
		
		Response response= RestAssured
//				.given().contentType("application/json")
				.given().contentType(ContentType.JSON)
				//.header(new Header("Authorization", "Bearer b30qNDF6TGy5qr86UBfATt7J48Aon2FVNKR-XiwnIDkZGYi2SpFg68xRZ5KrSQu23R8_87erAohxjkFMhUcbzg"))
//				.header(new Header("Accept", "application/xml"))
				.when()
				.body("{\"short_description\" : \"My New Incident\",\"category\":\"Hardware\"}")
				.accept(ContentType.JSON)
				.post()
				.then().contentType(ContentType.JSON).extract().response();
		
		
		response.prettyPrint();
		
	}

}
