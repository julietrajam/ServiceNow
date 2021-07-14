package Incident;


import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsFile {

	@Test
	public void IncidentCreateWithBody () {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev112646.service-now.com//api/now/table/incident";
		
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Bujju@123");
		
//		step3: request type (get) { ctrl+2 , l }
		File file = new File("./data/CreateIncident.json");
		
		Response response = RestAssured
				            .given()
				            .contentType(ContentType.JSON)
				            .body(file)
				            .post();
		
//		step4: print response body
		response.prettyPrint();
		
//		step5: print status code
		System.out.println(response.statusCode());
		
	}

}
