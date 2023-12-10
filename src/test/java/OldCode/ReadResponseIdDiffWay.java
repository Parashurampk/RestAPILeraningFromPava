/**
 * 
 */
package OldCode;

import org.testng.annotations.Test;
import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.internal.http.ContentTypeSubTypeExtractor;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * @author Parashuram
 *
 */
public class ReadResponseIdDiffWay {

	//@Test
	public void testGetResponseAsString() {

		String responseAsString = get("https://secure.drivezy.com/property?limit=250").asString();
		System.out.println("My Response:\n\n\n" + responseAsString);

	}
	
	//@Test
	public void testExtractDetailsUsingPath() {    //testExtractDetailsUsingPath
		String href=
		when()
		.get("http://jsonplaceholder.typicode.com/photos/1")
		.then()
			.contentType(ContentType.JSON)
			.body("albumId",equalTo(1))
		 .extract()
		 	.path("url");
		 System.out.println(href);
		
		when().get().then().statusCode(200);
						
	}
	
	@Test
	public void testExtractDetailsUsingResponse() {     //testExtractDetailsUsingResponse
		Response response=
		when()
			.get("http://jsonplaceholder.typicode.com/photos/1")
		.then()
		.extract()
		.response();
		
		System.out.println("Content type:  "+ response.contentType());
		System.out.println("Href:  "+ response.path("url"));
		System.out.println("Status Code:  "+ response.statusCode());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
