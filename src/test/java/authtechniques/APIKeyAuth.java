package authtechniques;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class APIKeyAuth {
	
	@Test
	public void apiKeyAuth()
	{

		baseURI= "https://api.openweathermap.org";
		String apiKey="966d3835c0035eac7e492df3099c25ee";
		
		given()
			.accept("application/json")
			.contentType(ContentType.JSON)
			.queryParam("lat", "18.5204")
			.queryParam("lon", "73.8567")
			.queryParam("cnt", "5")
			.queryParam("appid", apiKey)
		
		.when()
			.get("/data/2.5/forecast/weather")
			
		
		.then()
			.statusCode(200)
			.log().all();
	
	}
	
	////966d3835c0035eac7e492df3099c25ee    Openweather sanjaykey

}
