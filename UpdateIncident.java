package Incident;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Test
public class UpdateIncident {

	public void incidentUpdate() {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev112646.service-now.com//api/now/table/";
		
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Bujju@123");
		
//		step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured
				            .given()
				            .contentType(ContentType.JSON)
				            .body("{ \"short_description\":\"Display Issue\", \"category\":\"Hardware\" } ")
				            .pathParam("sysID", "abfc375e1b553010d535c803604bcb37")
				            .patch("incident/{sysID}");
		//Put               .put("incident/{sysID}");
		
//		step4: print response body
		response.prettyPrint();
		
//		step5: print status code
		System.out.println(response.statusCode());
		
	}

}
