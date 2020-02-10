/**
 * 
 */
package com.test.automation.RestAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author nagarjuna
 *
 */
public class TC001_Get_Request {
	
	/*100-level (Informational) — Server acknowledges a request
	200-level (Success) — Server completed the request as expected
	201-level (Created)- Server created the request
	300-level (Redirection) — Client needs to perform further actions to complete the request
	400-level (Client error) — Client sent an invalid request
	500-level (Server error) — Server failed to fulfill a valid request due to an error with server
	400 Bad Request — Client sent an invalid request — such as lacking required request body or parameter
    401 Unauthorized — Client failed to authenticate with the server
    403 Forbidden — Client authenticated but does not have permission to access the requested resource
    404 Not Found — The requested resource does not exist
    412 Precondition Failed — One or more conditions in the request header fields evaluated to false
    500 Internal Server Error — A generic error occurred on the server
    503 Service Unavailable — The requested service is not available
	*/
	
	@Test
	public void getweatherDetails() {
		
		  //Specify base URI
		  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		  
		  //Request object to the server
		  RequestSpecification httpRequest = RestAssured.given();
		  
		  //Response object from the server
		  Response response = httpRequest.request(Method.GET,"/Bellary");
		  
		  //print server response in console window
		  String responseBody = response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //status code validation
		  int statusCode = response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 200);
		  
		  //status line verification
		  String statusLine = response.getStatusLine();
		  System.out.println("Status line is: "+statusLine);
		  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}
