package test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

//As API documentation is not available, so checking if site is available with status code as 200.
public class RestAssuredApi {

	public static void main(String[] args) {
		
		//Validate if Get request is working as expected.
		//Given - All input details
		//When - https get method is called
		//Then - Validate the response is 200
		RestAssured.baseURI="https://buggy.justtestit.org/";
		
		String getResp = given().when().get("register")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		System.out.println(getResp);
		
	}

}
