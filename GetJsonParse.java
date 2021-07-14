package Incident;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetJsonParse {
	
	public static void main(String args[])
	{

	RestAssured.baseURI = "https://dev112646.service-now.com//api/now/table/incident";
//	step2: Authentication (basic)
	RestAssured.authentication = RestAssured.basic("admin", "Bujju@123");
	
	Response response = RestAssured.given().get();
	
	System.out.println(response.statusCode());
	
	JsonPath jsonPath = response.jsonPath();
	
	List<String> list = jsonPath.getList("result.number");
	
	System.out.println(list.size());
	
	
	
	
  }
	
}
