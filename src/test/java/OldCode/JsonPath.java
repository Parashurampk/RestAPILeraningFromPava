/**
 * 
 */
package OldCode;

import org.testng.annotations.Test;

import groovy.time.BaseDuration.From;
import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.internal.http.ContentTypeSubTypeExtractor;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

/**
 * @author Parashuram
 *
 */
public class JsonPath {
	
	@Test
	public void testJsonPath1() {
		String responseAsString=
		when()
			.get("http://jsonplaceholder.typicode.com/photos")
		.then()
			.extract().asString();
		
	//	List<Integer>albumIds=from(responseAsString).get("id");
		//System.out.println(albumIds.size());
		
	}

}
