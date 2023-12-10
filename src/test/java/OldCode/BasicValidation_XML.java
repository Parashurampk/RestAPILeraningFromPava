package OldCode;
/*
 1.Verifying Single Content in in XML response 
 	.body("CUSTOMER.ID",equalTo("15"))
 	
 2.Verifying Multiple Content in in XML response 
 	.body("CUSTOMER.ID",equalTo("15"))
	.body("CUSTOMER.FIRSTNAME",equalTo("Billa"))
 
 3.Verifying All the Content in in XML response in one go
 	.body("CUSTOMER.text()",equalTo("15BillaClancy"));
 	
 4.Find values using XML Path in XML response
 	.body(hasXPath("CUSTOMER/FIRSTNAME",containsString("Bill")));
 	
 5.Xpath with text() function
 	.body(hasXPath("/INVOICEList/INVOICE[text()='30']"));
  
 */

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class BasicValidation_XML {
	
	@Test //Verifying Single Content in in XML response 
	public void testSingleContent() {
		
		given()
		.when()
			.get("https://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.ID",equalTo("15"))
			.log().all();
			
		
	}
	
	@Test //Verifying Multiple Content in in XML response 
	public void testMultipleContent() {
		
		given()
		.when()
			.get("https://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.ID",equalTo("15"))
			.body("CUSTOMER.FIRSTNAME",equalTo("Billa"))
			.body("CUSTOMER.LASTNAME",equalTo("Clancy"));
					
	}
	
	@Test //Verifying All the Content in in XML response in one go
	public void testMultipleContentInOneGo() {
		
		given()
		.when()
			.get("https://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.text()",equalTo("15BillaClancy"));
		//  Use ".text" function and then keep all the response data in "one line without space"								
	}
	
	
	
	@Test //Find values using XML Path in XML response
	public void testUsingXpath1() {
		
		given()
		.when()
			.get("https://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body(hasXPath("CUSTOMER/FIRSTNAME",containsString("Bill")));
	}	
	
	@Test //Xpath with text() function
	public void testUsingXpath2() {
		
		given()
		.when()
			.get("https://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"));
	}
}












































