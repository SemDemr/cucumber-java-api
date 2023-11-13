package com.qa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import com.qa.utils.APIConstants;

public class GetOneBookSteps {

	RequestSpecification getOneBookRequest;
	Response getOneBookResponse;

	@Given("I create a get one book request")
	public void i_create_a_get_one_book_request() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		getOneBookRequest = RestAssured.given();
	}

	@Given("I provide the ISBN {string} as a query parameter")
	public void i_provide_the_isbn_as_a_query_parameter(String isbn) {
		getOneBookRequest.queryParam("ISBN", isbn);
	}

	@When("I make a GEt call to Get One Book endpoint")
	public void i_make_a_g_et_call_to_get_one_book_endpoint() {
		getOneBookResponse = getOneBookRequest.when().get(APIConstants.GET_ONE_BOOK_ENDPOINT);

		getOneBookResponse.prettyPeek();

	}

	@When("I validate that the status code for getting a book is {int}")
	public void i_validate_that_the_status_code_for_getting_a_book_is(Integer status) {
		getOneBookResponse.then().assertThat().statusCode(status);
	}

	@When("I validate that the ISBN in the response body is {string}")
	public void i_validate_that_the_isbn_in_the_response_body_is(String expectedISBN) {
		getOneBookResponse.then().assertThat().body("isbn", equalTo(expectedISBN));
	}

	@Then("I validate that the book title is {string}")
	public void i_validate_that_the_book_title_is(String expectedTitle) {
		
	getOneBookResponse.then().assertThat().body("title",equalTo(expectedTitle));
	
	
	}

}
