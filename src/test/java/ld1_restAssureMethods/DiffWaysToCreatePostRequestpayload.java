package ld1_restAssureMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import api.test.pojoPostRequest;


public class DiffWaysToCreatePostRequestpayload {
	
	@Test(priority = 1)
	void createUser() {
		
		HashMap data=new HashMap();
		data.put("name","Prabhus");
		data.put("job","Engineer");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Prabhus"))
			.log().all();
			
	}

	@Test(priority = 2)
	void postUsingJsonLibrary() {
		
		JSONObject data=new JSONObject();
		data.put("name", "Prabhus");
		data.put("job","Engineerr");
		
		given()
			.contentType("application/json")
			.body(data.toString())//data should be in string format so will use toString()
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Prabhus"))
			.log().all();
  }
	

	@Test(priority = 3)
	void testPostusingPOJO() {
		
		pojoPostRequest data=new pojoPostRequest();
		data.setName("Parashuram");
		data.setJob("Engr");
	
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Parashuram"))
			.log().all();
	}
	
	@Test(priority = 4)
	void testPostusingExternalJsonFile() throws FileNotFoundException {
		
		File f=new File(".\\body.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject data= new JSONObject(jt);
		
	
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Prabhus"))
			.log().all();
	}
} 