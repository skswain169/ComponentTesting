package authtechniques;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Oauth {
	

	
	@Test
	
	public void OAuth()
	{
		baseURI= "https://gorest.co.in";
		String token="f3a4661a5a0ba2cacc0c34f1e23bc19ba7374d531ed014502113b7b4d2654cdf";
		
		given()
			.accept("application/json")
			.contentType(ContentType.JSON)
			.auth().oauth2(token)
		
		.when()
			.get("/public/v2/users/2858")
			
		
		.then()
			.statusCode(200)
			.log().all();
	}
//f3a4661a5a0ba2cacc0c34f1e23bc19ba7374d531ed014502113b7b4d2654cdf

	
	

}
