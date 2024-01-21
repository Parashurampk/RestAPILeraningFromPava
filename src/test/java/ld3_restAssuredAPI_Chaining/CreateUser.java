package ld3_restAssuredAPI_Chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {

	
	@Test
	void test_CreateUser(ITestContext context)
	{
		Faker faker=new Faker();
		
		JSONObject data= new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken="0a474a560a32005f40206236d875ae27fc87856e87ac22d8ef3054cebcfe39ea";
		
		int id =given()
			.header("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		
		System.out.println("Generated id is "+id);
		
		context.setAttribute("user_id", id); //Creating global variable
	}
	
}
