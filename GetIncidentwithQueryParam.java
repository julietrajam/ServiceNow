package Incident;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetIncidentwithQueryParam {

	public static void main(String[] args) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev112646.service-now.com//api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Bujju@123");
//		step3: request type (get) { ctrl+2 , l }
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("sysparm_fields","number,category,sys_id");
		params.put("category", "inquiry");
		
		
      Response response = RestAssured.given().
    		              /*queryParam("sysparm_fields", "number,sys_id,category").
    		              queryParam("category", "inquiry")*/
    		              queryParams(params)
    		             .get();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
                                           } 
}
	
