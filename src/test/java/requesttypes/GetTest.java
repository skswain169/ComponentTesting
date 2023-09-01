package requesttypes;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetTest {

	@Test
	public void getTest() {

		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		Assert.assertEquals(res.getStatusCode(), 200);

	}

	@Test
	public void getTestBDD() {

		//baseURI = "https://reqres.in/";
		
		baseURI ="http://localhost:3001";

		given()
			.queryParam("page", 2)
		.when()
			.get("/api/users")
		.then()
			.statusCode(200)
			//.body("data[1].id", equalTo(8))
			//.body("data.last_name", hasItems("Lawson","Fields"))
			.log().all();

	}

}
