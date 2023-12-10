package OldCode;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class GETMethodTest {
	
	@Test
	public void demoTest() {
		
		given()
		.when()
			.get("https://secure.drivezy.com/property?limit=250")
		.then()
			.statusCode(200)	
			.statusLine("HTTP/1.1 200 OK")
			.contentType("application/json")
			.header("Content-Length","12489")
			.header("Connection", "keep-alive")
			.log().all() //Print all response body in console
			
			.assertThat().body("response.id[0]",equalTo(1))
			.assertThat().body("response.property_name[0]",equalTo("utl.splitpayment.minlimit"))
			.assertThat().body("response.property_value[0]",equalTo(".15"))
			.assertThat().body("response.description[0]",equalTo("Minimum % of amount to be payable"))
			.assertThat().body("response.created_by[0]",equalTo(1321))
			.assertThat().body("response.updated_by[0]",equalTo(4568))
			.assertThat().body("response.created_at[0]",equalTo("2016-01-11 17:35:53"))
			.assertThat().body("response.updated_at[0]",equalTo("2017-04-17 13:12:47"))
			.assertThat().body("response.deleted_at[0]",equalTo(null))
		
			.assertThat().body("response.id[1]",equalTo(2))
		
			.assertThat().body("response.property_name[2]",equalTo("ubiq.kms.cap"))
		
			//Note: equalTo and hasItems are Hamcrest matchers which you should statically import from org.hamcrest.Matchers.
			.assertThat().body("response.id",hasItems(1,2,3,4,5,6,7,8,9,10)); //To check multiple parameters then we use "hasItems"
			
			
			
			
			
		
	}
		
}
