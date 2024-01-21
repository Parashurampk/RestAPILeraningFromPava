package ld4_RestAssuredPreparation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPITest {

	@Test
	public void GetBooksDetails() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "");

		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
//	    System.out.println(response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);

		Headers allHeaders = response.headers();	
		for (Header header : allHeaders) {
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
		
		ResponseBody body = response.getBody();
		System.out.println("Response Body is: " + body.asString());
	}
}