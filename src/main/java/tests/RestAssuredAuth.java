package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.DataBuilder;

import static io.restassured.RestAssured.given;

public class RestAssuredAuth {
	
	String token;
	String id;
	
	@Test
	public void createToken() {	
		Response resp = given().
							contentType(ContentType.JSON).
							body(DataBuilder.buildToken().toJSONString()).
							post("https://restful-booker.herokuapp.com/auth").
							then().
							statusCode(200).
							extract().
							response();
				
		System.out.println(resp.asString());
		token = resp.jsonPath().getString("token");
	}

}
