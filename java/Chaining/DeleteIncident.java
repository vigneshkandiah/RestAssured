package Chaining;

import java.util.List;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident extends BaseRequest {
	//path of method -> pakagename .classname.method
	@Test(dependsOnMethods = "Chaining.CreateIncidentWithBody.createIncident")
	@Parameter()
	public void deleteIncident() {
                 Response response= request
		.given().pathParam("ID",sys_id)
				.delete("{ID}");
		int statusCode = response.getStatusCode();
		
		System.out.println(statusCode);
	}

}
