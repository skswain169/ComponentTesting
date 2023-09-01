package requesttypes;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteTest {

	
	

	@Test
	public void deleteTest() {
	baseURI ="https://reqres.in/";
	
	

	when()
		.delete("/api/users/2")
	.then()
		.statusCode(204)
		.log().all();
	
	}
	
	




}
