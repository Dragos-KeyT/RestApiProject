package tests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoookingDates {

	/* "bookingdates" : {
	        "checkin" : "2018-01-01",
	        "checkout" : "2019-01-01"
	    },*/
	
	public String checkin;
	public String checkout;
	
	public String toString() {
		return "BookingDates {"
				+"checkin='"+checkin+"'"+
				",checkout='"+checkout+"'"+
				"}";

	}
	
}
