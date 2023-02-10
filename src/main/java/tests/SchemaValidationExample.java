package tests;

import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidationExample {

	@Test
	public void validateSchema() {
		
		Response resp = given().
				get("https://keytrcrud.herokuapp.com/api/users/63e4ae3f750d2800134651f1").
				then().
				statusCode(200).
				extract().
				response();
		
		System.out.println(resp.asString());
		
		assertThat(resp.asString(), matchesJsonSchemaInClasspath("schema.json"));
		
	}
	
	
	
}
