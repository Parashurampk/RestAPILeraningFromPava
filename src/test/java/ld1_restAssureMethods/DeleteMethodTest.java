package ld1_restAssureMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteMethodTest {
	
	@Test
	public void deleteEmployeeRecord() {
		RestAssured.baseURI="http://...........";
		RestAssured.basePath="/delete/11493";
		
		Response response=
		given()
			
		.when()
			.delete()
			
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response(); //Extract the complete response
		
			String  jsonString=response.asString();
			Assert.assertEquals(jsonString.contains("Successfully! deleted records"), true);
		
		
	}

}
