package Day5_API_Chaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test
	void testGetuser(ITestContext context) {
		
		int id=(int) context.getAttribute("user_id"); //this come form CreateUser request
		
        String bearerToken="0a474a560a32005f40206236d875ae27fc87856e87ac22d8ef3054cebcfe39ea";
		
		 given()
			.header("Authorization", "Bearer "+bearerToken)
			.pathParam("id",id)
		
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}

}
