package ld3_restAssuredAPI_Chaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	@Test
	void test_deleteUser(ITestContext context)
	{
		String bearerToken="0a474a560a32005f40206236d875ae27fc87856e87ac22d8ef3054cebcfe39ea";
		
		int id=(int) context.getAttribute("user_id");
		
		given()
		.header("Authorization", "Bearer "+bearerToken)
		.pathParam("id", id)
		
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
			
		.then()
			.statusCode(204)
			.log().all();
	}
}
