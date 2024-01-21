package ld2_restAssuredDataValidation;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class jsonschemaValidation {
	
	@Test
	void jsonschemavalidation()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
         .then()
         	.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storejsonSchema.json"));
	}						
}                //JsonSchemaValidator-free defined class
                 //matchesJsonSchemaInClasspath - is method where we will specify json file 
