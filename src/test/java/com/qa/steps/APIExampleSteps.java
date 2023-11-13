package com.qa.steps;

import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.utils.APIConstants;
import com.qa.utils.APIGlobalVariables;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIExampleSteps {
	
	
	Response response;
	
	@When("I add a book to the account")
	public void i_add_a_book_to_the_account() {
		String payload = "{\r\n"
				+ "  \"userId\": \""+APIGlobalVariables.userID +"\",\r\n"
				+ "  \"collectionOfIsbns\": [\r\n"
				+ "    {\r\n"
				+ "      \"isbn\": \""+APIGlobalVariables.book1 +"\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"isbn\": \""+APIGlobalVariables.book2 +"\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	
RestAssured.baseURI = APIConstants.BASE_URI;
		
		RestAssured.given()
		.auth().oauth2(APIGlobalVariables.token)
		.body(payload)
		.contentType(ContentType.JSON)
		.when()
		.post(APIConstants.ADD_LIST_OF_BOOKS_ENDPOINT);
	
	
	
	}

	@When("I get the account information")
	public void i_get_the_account_information() {
	   
		
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		response = RestAssured.given()
		//.header("Authorization", "Bearer"+ APIGlobalVariables.token)
		.auth().oauth2(APIGlobalVariables.token)
		.pathParam("UUID", APIGlobalVariables.userID)
		
		.when()
		.get(APIConstants.GET_ACCOUNT_ENDPOINT).prettyPeek();
		
		
		
		
		
		
	}

	@Then("I validate that the book is in the account")
	public void i_validate_that_the_book_is_in_the_account() {
	    
		//validate book is in the response 1st way
				response.then().assertThat().body("books[0].isbn", equalTo(APIGlobalVariables.book1));
				
				//validate book is in the response 2nd way - JUnit Assertion
				String firstISBN = response.body().jsonPath().getString("books[0].isbn");
				
				Assert.assertEquals(APIGlobalVariables.book1, firstISBN);

				//validate the second book is in the response 
				response.then().assertThat().body("books[1].isbn", equalTo(APIGlobalVariables.book2));
				
				//get username
				String bodyUsername = response.body().jsonPath().getString("username");
				System.out.println("Username is: "  + bodyUsername);
				
				//get the number of pages for the second book
				int secondBookPages = response.getBody().jsonPath().getInt("books[1].pages");
				System.out.println("The second books has "+ secondBookPages + " pages");
				
				//get one book
				Map<String, String> book1 = response.body().jsonPath().getMap("books[0]");
				System.out.println(book1);

				//get all isbn in a list
				List<String> all_isbn = response.body().jsonPath().getList("books.isbn");
				System.out.println(all_isbn);
		
		
		
		
		
		
		
	}
}
