package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class CrudExamples {
	
	String id;
	JSONObject body;
	
	@BeforeClass
	public void setup() {
		
		RestAssured.baseURI = "https://keytodorestapi.herokuapp.com/";
		
		
		body = new JSONObject();
		
		Faker faker =  new Faker();
		body.put("title", faker.lordOfTheRings().character());
		body.put("body", faker.chuckNorris().fact());
		
	}

	
	@Test
	public void createTodo() {
		
		Response resp = 
				given().
					contentType(ContentType.JSON).
					body(body.toJSONString()).
					post("api/save").
				then()
					.statusCode(200)
					.body("info", is(equalTo("Todo saved! Nice job!")))
					.body("id",is(anything()))
					.log().all()
					.extract().response();	
		
		id= resp.jsonPath().getString("id");
	}

}
