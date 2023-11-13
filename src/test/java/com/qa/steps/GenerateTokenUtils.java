package com.qa.steps;

import com.qa.utils.APIConstants;
import com.qa.utils.ConfigsReader;
import com.qa.utils.Constants;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class GenerateTokenUtils {

	public static String token;
	
	String payload="";
	
	@Given("a token is generated")
	public void a_token_is_generated() {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String username = ConfigsReader.getProperty("APIUsername");
		String password = ConfigsReader.getProperty("APIPassword");
		
		String payload = "{\n" + username + password + "}";
		
		
		RestAssured.baseURI = APIConstants.BASE_URI;
	RestAssured.given()
	.header("Content-Type","application/json")
	.body(payload)
	.when()
	.post(APIConstants.GENERATE_TOKEN_ENDPOINT)
	.body().jsonPath().get("token")	;
	
	
	
	
	
	
	}




}
