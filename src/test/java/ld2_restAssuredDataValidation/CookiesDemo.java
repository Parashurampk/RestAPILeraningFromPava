package ld2_restAssuredDataValidation;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class CookiesDemo {

	
	@Test
	void testCookies() {
		
		
		given()
		
		.when()
			.get("Https://www.google.com/")
		
		.then()
			.cookie("AEC","xxxxxxxxxxxxxxxxxx") // new cookie values will generate every time newly
			.log().all();
		
		   //.log().cookies()
		   //.log().headers();
	}
}
