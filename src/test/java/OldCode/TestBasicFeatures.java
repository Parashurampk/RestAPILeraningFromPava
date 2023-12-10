package OldCode;

import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestBasicFeatures {

	//@Test
	public void testStatusCode() {
		
		given().
		when()
			.get("https://secure.drivezy.com/city?includes=venue,car,city_link,car.make")
		.then()
			.statusCode(200)  // Check status code
			.log().all();	 // Print complete response in console	
	}
	
	
	@Test 
	public void testEqualFunction() {
		
		given()
		.when()
			.get("https://secure.drivezy.com/property?limit=250")
		.then()
			.body("response.property_name[0]",equalTo("utl.splitpayment.minlimit")) //verify single content
			.body("response.property_value[0]",equalTo(".15"));	
	}
	
	//@Test
	public void testHasItemfunction() {
		
		given()
		.when()
			.get("https://secure.drivezy.com/property?limit=250")
		.then()
			.body("response.property_name[0]",hasItems("1321"));//verify multiple content
		
	}
	
	//@Test
	public void testParameters() {
		
		given()
		  .param("key1", "value1")
		  .header("header","value")
		 .when()
		 	.get("https://secure.drivezy.com/property?limit=250")
		 .then()
		 	.statusCode(200);
			
		 	
	}
	
	//@Test
	public void testParametersReadablity() {
		
		given().param("key1", "value1").header("header","value").when().get("https://secure.drivezy.com/property?limit=250") .then().statusCode(200);		 	
	}

}





















