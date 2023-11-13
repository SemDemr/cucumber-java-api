package com.qa.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.utils.CommonMethods;
import com.qa.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {

	@Given("user navigates to Add employee page")
	public void user_navigates_to_add_employee_page() {
		wait(3);
		click(dashboard.PIM);
		click(dashboard.addEmployeeLink);
		wait(3);
	}

	@Then("user enters employee first name and last name")
	public void user_enters_employee_first_name_and_last_name() {
		sendText(dashboard.firstName, "Charlie");
		sendText(dashboard.lastName, "Chaplin");

	}

	@Then("selects the location")
	public void selects_the_location() {
		selectDropdown(addEmployee.location, "London Office");

		wait(2);
	}

	@And("get employee ID")

	public static String get_employee_ID() {
		String expectedEmpId = addEmployee.employeeId.getAttribute("value");
		return expectedEmpId;
	}

	@Then("user clicks save button")
	public void clicks_save_button() {

		click(addEmployee.saveBtn);
	}

	@Then("I validate the employee with ID")
	public void i_validate_the_employee_withID() {
		waitForVisibility(personalDetails.personalDetailsForm);
		String expectedEmpId = get_employee_ID();

		String actualEmpId = personalDetails.employeeId.getAttribute("value");
		if (expectedEmpId.equals(actualEmpId)) {
			System.out.println("Test PASSED!");
		} else {
			System.out.println("Test FAILED!");

		}
	}

	@Then("I validate the employee")
	public void i_validate_the_employee() {
		String expectedName = "Mpr";
		String actualName = personalDetails.employeeName.getText();
		if (expectedName.equals(actualName)) {
			System.out.println("Employee Name Validated");
		} else {
			System.out.println("Employee Name NOT Validated");
		}

	}

	@Then("delete employee id")
	public void delete_employee_id() {
		(addEmployee.employeeId).clear();
	}

	@Then("switch login details button")
	public void switch_login_details_button() {
		jsClick(addEmployee.checkBoxLoginDetails);
	}

	@Then("enters username and password and confirms password")
	public void enters_username_and_password_and_confirms_password() {
		sendText(addEmployee.username, "chrCplin");
		sendText(addEmployee.password, "Chrl@200220");
		sendText(addEmployee.confirmPassword, "Chrl@200220");
	}

	@Then("user enters employee {string} and {string}")
	public void user_enters_employee_and(String firstName, String lastName) {
		sendText(dashboard.firstName, firstName);
		sendText(dashboard.lastName, lastName);
	}

	@When("user enters employee {string}, {string} and {string}")
	public void user_enters_employee_and(String first_name, String middle_name, String last_name) {
		sendText(addEmployee.firstName, first_name);
		sendText(addEmployee.middleName, middle_name);
		sendText(addEmployee.lastName, last_name);
	}

	@When("user selects a location {string}")
	public void user_selects_a_location(String location) {
		selectDropdown(addEmployee.location, location);
	}

	@Then("validate that {string} and {string} is added successfully")
	public void validate_that_and_is_added_successfully(String firstN, String lastN) {
		waitForVisibility(personalDetails.personalDetailsForm);

		String expectedName = firstN + " " + lastN;
		String actualName = personalDetails.employeeName.getText();

		Assert.assertEquals("The name DOES NOT match!", expectedName, actualName);
	}

	@When("user selects a location")
	public void user_selects_a_location() {
		selectDropdown(addEmployee.location, "London Office");
	}

	// Extra methods from DataTable
	@When("user enters employee details and clicks on save and validates it is added")
	public void user_enters_employee_details_and_clicks_on_save_and_validates_it_is_added(DataTable table) {
		System.out.println(table);

		// asMaps() method converts DataTable into a List of Maps
		List<Map<String, String>> empList = table.asMaps();
		// System.out.println(empList);

		for (Map<String, String> employee : empList) {
			System.out.println(employee);

			String fName = employee.get("FirstName");
			String mName = employee.get("MiddleName");
			String lName = employee.get("LastName");

			sendText(addEmployee.firstName, fName);
			sendText(addEmployee.middleName, mName);
			sendText(addEmployee.lastName, lName);

			selectDropdown(addEmployee.location, "London Office");

			wait(1);

			click(addEmployee.saveBtn);

			waitForVisibility(personalDetails.personalDetailsForm);

			// Validation
			String expectedTxt = fName + " " + lName;
			String actualTxt = personalDetails.employeeName.getText();

			Assert.assertEquals("The name DOES NOT match!", expectedTxt, actualTxt);

			// Before next iteration
			// We need to go to Add Employee page again
			wait(1);
			click(dashboard.addEmployeeLink);
		}
	}

	@When("user enters employee data from {string} excel sheet then save")
	public void user_enters_employee_data_from_excel_sheet_then_save(String sheetName) {

		String path = System.getProperty("user.dir") + "/src/tst/resources/testdata/Excel.xlsx";
		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(path, sheetName);

		for (Map<String, String> dataMap : excelList) {

			String fName = dataMap.get("FirstName");
			String lName = dataMap.get("LastName");
			String user = dataMap.get("Username");
			String pass = dataMap.get("Password");
			sendText(addEmployee.firstName, fName);
			sendText(addEmployee.lastName, lName);
			selectDropdown(addEmployee.location, "London Office");

			wait(1);
		
			sendText(addEmployee.username, user);
			sendText(addEmployee.password, pass);
			sendText(addEmployee.confirmPassword, pass);
		
			wait(1);
		
			
			click(addEmployee.saveBtn);

			waitForVisibility(personalDetails.personalDetailsForm);

			// Validation
			String expectedTxt = fName + " " + lName;
			String actualTxt = personalDetails.employeeName.getText();

			Assert.assertEquals("The name DOES NOT match!", expectedTxt, actualTxt);

			// Before next iteration
			// We need to go to Add Employee page again
			wait(1);
			click(dashboard.addEmployeeLink);
			
			
			
		
		
		}

	}

}
