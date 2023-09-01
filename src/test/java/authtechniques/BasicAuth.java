package authtechniques;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;

public class BasicAuth {
	
	@Test
	
	public void basicAuth()
	{
		baseURI= "https://postman-echo.com";
		
		given()
			.accept("application/json")
			.contentType(ContentType.JSON)
			.auth().basic("postman","password")
		
		.when()
			.get("/basic-auth")
			
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}

}
