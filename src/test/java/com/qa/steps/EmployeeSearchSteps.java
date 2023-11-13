package com.qa.steps;

import com.qa.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods{

	

	@Given("user navigates to the employee list page")
	public void user_navigates_to_the_employee_list_page() {
		click(dashboard.PIM);

		click(dashboard.employeeListLink);
	}

	@When("user enters valid employee id")
	public void user_enters_valid_employee_id() {
		sendText(employeeList.searchBox, "1007");
	}
	@When("user enters valid employee first and last name")
	public void user_enters_valid_employee_first_and_last_name() {
		sendText(employeeList.searchBox, "Alice Duval");
	}
	@When("clicks on search button")
	public void clicks_on_search_button() {
		click(employeeList.searchIcon);  
	}

	@Then("employee information is displayed")
	public void employee_information_is_displayed() {
		System.out.println("Employee is displayed :)");

		wait(5);
	}

	















}
