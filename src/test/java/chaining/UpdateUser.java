package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	
	@Test
	@Parameters({"appBaseURI","token"})
	public void updateUser(String appbaseURI,String bearerToken,ITestContext context)
	{
		
		System.out.println("IN UPDATE");

		//int user_id=(Integer) context.getAttribute("user_id");
		int user_id=(Integer) context.getSuite().getAttribute("userid");
		
		baseURI=appbaseURI;
		
		//String bearerToken="f3a4661a5a0ba2cacc0c34f1e23bc19ba7374d531ed014502113b7b4d2654cdf";
		
		Faker faker= new Faker();
		JSONObject js=new JSONObject();
		js.put("name", faker.name().fullName());
		js.put("gender", "male");
		js.put("email", faker.internet().emailAddress());
		js.put("status", "inactive");
		
		//id : 4988059
		given()
			.accept("application/json")
			.contentType("application/json")
			.header("Authorization", "Bearer "+bearerToken)
			.body(js.toJSONString())
			.pathParam("u_id", user_id)
		
		.when()
			.put("/public/v2/users/{u_id}")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	



}
