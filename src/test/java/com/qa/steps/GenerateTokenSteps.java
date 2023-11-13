package com.qa.steps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import com.qa.utils.APIConstants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenerateTokenSteps {

RequestSpecification request;
Response response;

@Given("I create generate token request")
public void i_create_generate_token_request() {
	RestAssured.baseURI = APIConstants.BASE_URI;
	request = RestAssured.given();
}

@Given("I provide the header for generate token request")
public void i_provide_the_header_for_generate_token_request() {
    //request.header("ContentType","application/json");
    request.contentType(ContentType.JSON);

}

@Given("I provide the body for generate token request")
public void i_provide_the_body_for_generate_token_request() {
	String payload = "{\r\n"
			+ "  \"userName\": \"NeotechAPI\",\r\n"
			+ "  \"password\": \"Neotech@2022\"\r\n"
			+ "}";
	
	request.body(payload);

}

@When("I make a Post call to generate token endpoint")
public void i_make_a_post_call_to_generate_token_endpoint() {
	response = request.post(APIConstants.GENERATE_TOKEN_ENDPOINT);
	
	response.prettyPeek();
}

@Then("I validate the status code for generate token request is {int}")
public void i_validate_the_status_code_for_generate_token_request_is(Integer statusCode) {
	response.then().assertThat().statusCode(statusCode);
}
@Then("I validate that the body contains {string}")
public void i_validate_that_the_body_contains(String success) {
//	response.then().assertThat().body("status", containsString(success));
	
		response.then().assertThat().body(containsString(success));
}

@Then("I validate that the value of the {string} is {string}")
public void i_validate_that_the_value_of_the_is(String key, String value) {
	System.out.println("Key: " + key);
	System.out.println("Value: "+ value);
	
	//this is checking that "result" key in the body has the value exactly as we passed it from the 
	//feature file
	response.then().assertThat().body(key, equalTo(value));
	
	//we could also check it this way, but this is without key
//	response.then().assertThat().body(equalTo(value));
}






}
