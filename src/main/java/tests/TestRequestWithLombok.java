package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.DataBuilder;

public class TestRequestWithLombok {
	
	@Test(priority =1)
	public void createBooking() {
		BoookingDates bookDates = new BoookingDates("2023-01-01", "2023-05-06");
		Booking booking =  new Booking("Test", "Ceva", 250, false, bookDates, "Breakfast");
		
		
		Response resp = given().
				contentType(ContentType.JSON).
				body(booking).
				post("https://restful-booker.herokuapp.com/booking").
				then().
				statusCode(200).
				extract().
				response();
		
		System.out.println(resp.asString());
	}
	
	

}
