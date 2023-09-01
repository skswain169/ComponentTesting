package requesttypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostTest {
	
	
	@Test
	public  void postTest()
	{
		
		baseURI ="https://reqres.in/";
		
		JSONObject jobj= new JSONObject();
		jobj.put("name", "Sanjay");
		jobj.put("job", "Developer");
		
		System.out.println("JSON object:"+jobj.toJSONString());
		
		
		given()
			.accept("application/json")
			.contentType(ContentType.JSON)
			.body(jobj.toJSONString())
		.when()
			.post("/api/users")
		.then()
			.statusCode(201)
			.log().all();
		
		
		
		
	}

}
