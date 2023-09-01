package chaining;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;



public class CreateUser {
	
	@Test
	@Parameters({"appBaseURI","token"})
	public void createUser(String appbaseURI,String bearerToken, ITestContext context)
	{
		
		//baseURI="https://gorest.co.in";
		baseURI=appbaseURI;
		//String bearerToken="f3a4661a5a0ba2cacc0c34f1e23bc19ba7374d531ed014502113b7b4d2654cdf";
		
		Faker faker= new Faker();
		JSONObject js=new JSONObject();
		
		js.put("name", faker.name().fullName());
		js.put("gender", "male"); 
		js.put("email", faker.internet().emailAddress());
		js.put("status", "active");
		
		//id : 4988059
		int id =given()
			.accept("application/json")
			.contentType("application/json")
			.header("Authorization", "Bearer "+bearerToken)
			.body(js.toJSONString())
		
		.when()
			.post("/public/v2/users")
		
		.then()
			.statusCode(201)
			.log().all()
			.extract().jsonPath().getInt("id")
			;
		
		System.out.println("Created user id is :"+id);
		
		//context.setAttribute("user_id", id);
		
		context.getSuite().setAttribute("userid", id);
	}
	
	

}
