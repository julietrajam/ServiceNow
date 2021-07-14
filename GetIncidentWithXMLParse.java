package Incident;


import java.util.List;
import java.util.Scanner;
import java.util.Timer;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetIncidentWithXMLParse {
	
		

	public static void main(String[] args) {
		
		
		
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev112646.service-now.com//api/now/table/incident";
		
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
      
      List<String> list=xPath.getList("response.result.number");
      
      System.out.println(list.size());
      
     System.out.println(list.get(list.size()-1));

     
     for (String eachNumber : list) {
   	  System.out.println(eachNumber);
	                                }
                                              
	
}
}
