package authtechniques;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DigestAuth {

	
	@Test
	
	public void digestAuth()
	{
		baseURI= "https://postman-echo.com";
		
		given()
			.accept("application/json")
			.contentType(ContentType.JSON)
			.auth().digest("postman","password")
		
		.when()
			.get("/basic-auth")
			
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}



}
