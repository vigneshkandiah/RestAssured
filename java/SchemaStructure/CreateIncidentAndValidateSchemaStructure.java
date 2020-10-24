package SchemaStructure;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class CreateIncidentAndValidateSchemaStructure {
	@Test

	public void createIncident() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";

		RestAssured.authentication=
				RestAssured.oauth2("2CnC8LV-oa7TiGNU1XAS5rMvbFn2e_KOg-szsGcIbSw3N6kyVefTViVaZoIMekIkOhx9vDrLh5JwPnVpXkoDlA");

		Map<String, String> param = new HashMap<String, String>();

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
				.assertThat().body(matchesJsonSchema("./SchemaStructure/SchemaStructure.json"))
				.statusCode(200)
				
				

				.extract().response();


		response.prettyPrint();

	}

}
