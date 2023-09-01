package authtechniques;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PreemptiveAuth {

	
	@Test
	
	public void preemptiveAuth()
	{
		baseURI= "https://postman-echo.com";
		
		given()
			.accept("application/json")
			.contentType(ContentType.JSON)
			.auth().preemptive().basic("postman","password")
		
		.when()
			.get("/basic-auth")
			
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}



}
