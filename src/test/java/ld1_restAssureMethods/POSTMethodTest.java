package ld1_restAssureMethods;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class POSTMethodTest {
	
	public static HashMap map=new HashMap();
	
	@BeforeClass
	public void postData() {
		
		map.put("name", "tesgtd");
		map.put("salary", "1552355");
		map.put("age", "32");
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/";
		RestAssured.basePath="create";
	}
	
	@Test(priority = 0)
	public void testPostrequest() {
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(200)
			.log().all()
			.body("status", equalTo("success"))
			.body("message", equalTo("Successfully! Record has been added."));			
	}
	//Using Hashmap
	@Test(priority = 1)
	void testPostusingHashMp() {
		
		HashMap data =new HashMap();
		data.put("name", "Scott");
		data.put("Job", "Leader");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all()
			.body("Job", equalTo("Leader"));			
	}
	
	//Using JSON Library
	
	 @Test(priority = 2)
	 void testPostUsingJson() {
		 JSONObject data=new JSONObject();
		 data.put("name", "Ram");
		 data.put("Job", "Role");
		 
		 
		 given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all()
			.body("Job", equalTo("Role"));
	 }
}

