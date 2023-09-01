package requesttypes;


import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class PatchTest {
	
	

	@Test
	public void patchTest() {
	baseURI ="https://reqres.in/";
	
	JSONObject jobj= new JSONObject();
	jobj.put("name", "Sanjay");
	jobj.put("job", "Sen Dev");
	
	System.out.println("JSON object:"+jobj.toJSONString());
	
	
	given()
		.accept("application/json")
		.contentType(ContentType.JSON)
		.body(jobj.toJSONString())
	.when()
		.post("/api/users/2")
	.then()
		.statusCode(201)
		.log().all();
	
	}
	
	


}
