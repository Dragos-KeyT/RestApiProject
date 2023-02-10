package utils;

import org.json.simple.JSONObject;

import com.github.javafaker.Faker;

public class DataBuilder {

	public static JSONObject buildTodo() {
		
		JSONObject bodyBuilder = new JSONObject();
		Faker faker =  new Faker();
		
		bodyBuilder.put("title", faker.book().title());
		bodyBuilder.put("body", faker.address().fullAddress());
		
		return bodyBuilder;
		
	}
	
	public static JSONObject buildUser() {
		
		JSONObject bodyBuilder = new JSONObject();
		Faker faker =  new Faker();
		
		bodyBuilder.put("name", faker.name().firstName());
		bodyBuilder.put("email", faker.internet().safeEmailAddress());
		bodyBuilder.put("age", faker.number().numberBetween(5, 130));
		bodyBuilder.put("gender", "m");
		
		return bodyBuilder;
		
	}
	
	public static JSONObject buildToken() {
		
		JSONObject body = new JSONObject();
		body.put("username", "admin");
		body.put("password", "password123");
		
		return body;
	}
	
	/*
	 * {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}'
	 */
	
	
	public static JSONObject buildBooking() {
		
		JSONObject booking = new JSONObject();
		booking.put("firstname", "Jim");
		booking.put("lastname", "Brown");
		booking.put("totalprice", 111);
		booking.put("depositpaid", true);
			JSONObject bookingDates = new JSONObject();
			bookingDates.put("checkin", "2023-01-01");
			bookingDates.put("checkout", "2023-05-01");
		booking.put("bookingdates", bookingDates);
		booking.put("additionalneeds", "Breakfast");

		return booking;
		
	}
	
	
	
	
}
