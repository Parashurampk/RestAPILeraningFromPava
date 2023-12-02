package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class parsingJSONResponsedata {

	
	@Test
	void testJSONResponse() {
		given()
		   .contentType("ContentType.JSON")
		.when()
			.get("https://localhost:3000/store")

			.then()
				.statusCode(200)
				.header("ContentType.JSON", "application/json;charset=utf-8")
				.body("book[3].title",equalTo("The lord of the Rings"));
		
				
	}
	
	@Test
	void test() {
		
			Response res= given()
			   .contentType("ContentType.JSON")
			.when()
				.get("https://localhost:3000/store");
				
				Assert.assertEquals(res.getStatusCode(), 200);
			    Assert.assertEquals(res.header("Content-Type"),"application/json; Charset=utf-8");
			    
			    String	bookname=res.jsonPath().get("book[3].title").toString();
			    assertEquals(bookname, "The lord of the Rings");
	}
}
