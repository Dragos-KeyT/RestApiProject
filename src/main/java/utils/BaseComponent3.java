package utils;

import org.testng.annotations.BeforeClass;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;


import io.restassured.builder.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;


public class BaseComponent3 {
	
	public static RequestSpecification requestSpec;
	public static ResponseSpecification responseSpec;
	
	@BeforeClass
	public void specificationBuilder() {
		
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("https://keytodorestapi.herokuapp.com/")
				.setBasePath("api/")
				.setContentType(ContentType.JSON)
				.addHeader("accept", "application/json")
				.build();
		
	
	}
	
	@BeforeClass
	public void respBuilder() {
		responseSpec = new ResponseSpecBuilder().
				expectStatusCode(either(is(200)).or(is(201)).or(is(204))).
				//expectStatusCode(200).	
				build();
	}
	
	
	
	public static Response doRequest(String httpMethod, String id, String body) {
		Response result = null;
		
		switch(httpMethod.toUpperCase()) {
		
		case "GET" : result = given().spec(requestSpec).get(id);
			break;
		case "POST": result = given().spec(requestSpec).body(body).post("save");
			break;
		case "PUT" : result = given().spec(requestSpec).body(body).put("todos/"+id);	
			break;
		case "DELETE": result = given().spec(requestSpec).delete("delete/"+id);	
			
		}
		if(result != null) {
			result = result.then().spec(responseSpec).extract().response();
		}
		
		return result;
	}
	
	
}
