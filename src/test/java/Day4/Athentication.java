package Day4;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Athentication {

	
	@Test(priority = 1)
	void testBasicAthentication() {
		
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	
	@Test(priority = 2)
	void testDigestAthentication() {
		
		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	
	@Test(priority = 3)
	void testPreemptiveAthentication() {
		
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	
	@Test(priority = 4)
	void testBearerTokenAthentication() {
		
		String bearerToken="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";
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
		.when()
			.get("https://api.github.com/user/repos")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 5)
	void testOuth1Athentication() {
		
		
		
		given()
			.auth().oauth(DEFAULT_URI, DEFAULT_SESSION_ID_VALUE, DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH)  // not able to find these
		.when()
			.get("https://api.github.com/user/repos")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 6)
	void testOuth2Athentication() {
		
		given()
			.auth().oauth2("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")  // Used dummy outh
		.when()
			.get("https://api.github.com/user/repos")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 7)
	void APIKeyAthentication() {
		
		given()
			.queryParam("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")  // need to get APIKey 
		.when()
			.get("https://api.github.com/user/repos")
		
		.then()
			.statusCode(200)
			.log().all();
	}
		
}
