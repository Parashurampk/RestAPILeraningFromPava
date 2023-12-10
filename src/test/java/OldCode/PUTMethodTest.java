package OldCode;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PUTMethodTest {
	
	public static HashMap map=new HashMap();
	
	String empName="Parashuram";
	int empSal=900000;
	int empAge=27;
	int empID=46104;
	
	@BeforeClass
	public void putData()
	{
		map.put("name", empName);
		map.put("salary", empSal);
		map.put("age", empAge);
		
		RestAssured.baseURI="	https://dummy.restapiexample.com/api/v1/"; //update/10
		RestAssured.basePath="/update"+"empID";
		
	}
	
	@Test
	public void testPUT() {
		given()
			.contentType("")   //Whenever we use post OR Put method we need 
			.body(map)                   //to specify the Content Type
		.when()  				//Under when section need to send request 
			.put() 				// by default it will take above url
		.then()   				//here need to verify the below things 
			.statusCode(200)
			.log().all();
	}
}




















