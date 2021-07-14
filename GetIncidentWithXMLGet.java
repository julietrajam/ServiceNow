package Incident;





import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetIncidentWithXMLGet {
	
		

	public static void main(String[] args) {
		
		try {
		
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev112646.service-now.com//api/now/table/incident/46c88ac1a9fe1981014de1c831fbcf6d";
		
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Bujju@123");
		
//		step3: request type (get) { ctrl+2 , l }
		
	  Response response = RestAssured.given()
			  .queryParam("sysparm_fields", "number,sys_id,category")
//			  .accept("application/xml");
			  .accept(ContentType.XML)
			  .get();
	  
//Print response body
	  response.prettyPrint();
	  
//    Print Status code 	  
	  System.out.println(response.statusCode());
	  
      XmlPath xPath = response.xmlPath();
      
     String sysid = xPath.get("response.result.sys_id");
      
      System.out.println("Sys ID:" +sysid);
      
		}catch(Exception e) {}     
     
}
}
