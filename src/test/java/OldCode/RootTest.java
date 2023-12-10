package OldCode;

import org.testng.annotations.Test;
import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RootTest {

	
	@Test
	public void testWithoutRoot() {           //testWithoutRoot
		
		given().
		when()
			.get("https://secure.drivezy.com/property?limit=250")
		.then()
			.body("response.property_name[0]",equalTo("utl.splitpayment.minlimit"))
			.body("response.property_value[0]",equalTo(".15"));
	}

	
	
	@Test
	public void testWithRoot() {               //testWithRoot
		
		given().
		when()
			.get("https://secure.drivezy.com/property?limit=250")
		.then()
			.root("response")
			.body("property_name[0]",equalTo("utl.splitpayment.minlimit"))
			.body("property_value[0]",equalTo(".15"));
	}
}
