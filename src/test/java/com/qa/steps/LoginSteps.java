package com.qa.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.utils.CommonMethods;
import com.qa.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {
	// LoginPageElements login;
	// DashboardPageElements dashboard;

	@Given("I navigated to the HRM website")
	public void i_navigated_to_the_hrm_website() {
		setUp();

		// login = new LoginPageElements();
		// dashboard = new DashboardPageElements();

	}

	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.logInButton);
	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		sendText(login.username, ConfigsReader.getProperty("username"));
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		click(login.logInButton);
	}

	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() {

		String expected = "Jacqueline White";

		String actual = dashboard.accountName.getText();

		if (expected.equals(actual)) {
			System.out.println("Validated");
		} else {
			System.out.println("test failed");
		}

	}

	@Then("I will quit the browser")
	public void i_will_quit_the_browser() {
		tearDown();
	}

	@When("I enter an invalid password")
	public void i_enter_an_invalid_password() {

		sendText(login.password, "12345");

	}

	@Then("I validate that")
	public void i_validate_that() {
		String expected = "Invalid Credentials";
		String actual = login.errorInvalidPassword.getText();
		if (expected.equals(actual)) {
			System.out.println("Validated");
		} else {
			System.out.println("Test failed");
		}

	}
	

	@When("user enters login information {string} and {string}")
	public void user_enters_login_information_and(String username, String password) {
		sendText(login.username, username);
		sendText(login.password, password);

		wait(2);

	}

	@Then("verify that the {string} is shown")
	public void verify_that_the_is_shown(String expectedAccountName) {
		String actualAccountName = dashboard.accountName.getText();

		Assert.assertEquals("The account name did not match!", expectedAccountName, actualAccountName);

	}

	
	

	@When("user enters username and password and clicks on the login button")
	public void user_enters_username_and_password_and_clicks_on_the_login_button(DataTable dataTable) {
	   List<Map<String,String>> listOfMaps = dataTable.asMaps();
	   System.out.println(listOfMaps);
	   
	   for(Map<String,String> map : listOfMaps) {
		   
		   System.out.println("Testing: " + map.get("username") + " : " + map.get("password"));
			// login
			sendText(login.username, map.get("username"));
			sendText(login.password, map.get("password"));

			click(login.logInButton);

			wait(1);

			// take a screenshot

			// validate
			String actualAccountName = dashboard.accountName.getText();

			Assert.assertEquals(map.get("employeeName"), actualAccountName);

			// logout
			dashboard.accountMenu.click();
			dashboard.logout.click();

		}
		   
		   
		   
		   
		   
	   }
	   
	   
	   
	   
	   
	    
	}
	
	
	
	
	
	
	
	

