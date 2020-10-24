package Assertions;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class CreateIncidentAndValidateWithEqulTo {
	@Test

	public void createIncident() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";

		RestAssured.authentication=
				RestAssured.oauth2("2CnC8LV-oa7TiGNU1XAS5rMvbFn2e_KOg-szsGcIbSw3N6kyVefTViVaZoIMekIkOhx9vDrLh5JwPnVpXkoDlA");

		Map<String, String> param = new HashMap<String, String>();

		param.put("sysparm_fields", "number,short_description,description,category,sys_class_name");
		param.put("category", "Software");
		param.put("sysparm_limit", "1");
		

		Response response= RestAssured
				//				.given().contentType("application/json")
				.given().contentType(ContentType.JSON)
				.queryParams(param)
				//.header(new Header("Authorization", "Bearer b30qNDF6TGy5qr86UBfATt7J48Aon2FVNKR-XiwnIDkZGYi2SpFg68xRZ5KrSQu23R8_87erAohxjkFMhUcbzg"))
				//				.header(new Header("Accept", "application/xml"))
				.when()
					.accept(ContentType.JSON)

				.get()
				.then().contentType(ContentType.JSON)
				.statusCode(200)	
                .body("result.number", hasItem("INC0000006"))
				.extract().response();


		response.prettyPrint();

	}

}
