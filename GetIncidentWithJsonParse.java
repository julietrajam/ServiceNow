package Incident;


import java.util.List;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetIncidentWithJsonParse {
	
		

	public static void main(String[] args) {
		
		try {
		
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev112646.service-now.com//api/now/table/incident";
		
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Bujju@123");
		
//		step3: request type (get) { ctrl+2 , l }
		
	  Response response = RestAssured.given().get();
	  
//     step4:Print response body
	  response.prettyPrint();
	  
//    Print Status code 	  
	  System.out.println(response.statusCode());
      
      JsonPath jsPath = response.jsonPath();
      
      List<String> list=jsPath.getList("result.number");
      
      System.out.println(list.size());
      
    
      //to print Incident numbers in horizontally
      for (String eachNumber : list) {
    	  System.out.println(eachNumber);
		
	                                }

                                              
	}catch(Exception e)
	{}
}
}
