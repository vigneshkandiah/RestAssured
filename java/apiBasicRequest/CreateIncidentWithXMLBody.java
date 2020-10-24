package apiBasicRequest;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CreateIncidentWithXMLBody {
	@Test
	
	public void createIncident() {

		RestAssured.baseURI="https://dev65622.service-now.com/api/now/table/incident";
		
		RestAssured.authentication=RestAssured.basic("admin", "Password@1");
		
		Response response = RestAssured
//				.given().contentType("application/json")
				.given().contentType(ContentType.XML)
				.when()
				.body("<request><entry><short_description>\"This is a new incident by BOT\"</short_description></entry></request>")
				.accept(ContentType.XML)
				
				.post();
		int statusCode = response.getStatusCode();
		
		XmlPath xmlPath = response.xmlPath();
		
		String short_desc = xmlPath.get("response.result.short_description");
		
		System.out.println(short_desc);
		
		System.out.println(statusCode);
	}

}
