package Day5_API_Chaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class UpdateUser {

	
	@Test
	void test_UpdateUser(ITestContext context)
	{
		Faker faker=new Faker();
		
		JSONObject data= new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender", "Female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken="0a474a560a32005f40206236d875ae27fc87856e87ac22d8ef3054cebcfe39ea";
		
		int id=(int) context.getAttribute("user_id");
		
			given()
			.header("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
	}	
}
