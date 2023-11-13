package com.qa.steps;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.qa.utils.CommonMethods;

import io.cucumber.java.en.Then;

public class PersonalDetailsSteps extends CommonMethods {

	@Then("I am able to modify Employee Details {string}, {string}, {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_details(String driverLic, String expDate, String smoker, String gender,
			String nation) {

		waitForVisibility(personalDetails.personalDetailsForm);

		sendText(personalDetails.driverLicense, driverLic);
		wait(1);

		if (smoker.equals("Yes")) {
			click(personalDetails.smokerBox);
		}
		wait(1);

		click(personalDetails.genderInput);
		// 1st way. Locating the WebElement dynamically
		// click(driver.findElement(By.xpath("//span[text()='" + gender + "']")));

		// 2nd way
		List<WebElement> genderList = personalDetails.genderOptions;

		wait(1);
		for (WebElement option : genderList) {
			if (option.getText().equals(gender)) {
				click(option);
				break;
			}
		}

		// Task until 8:20: Select the Nationality

		wait(5);

	}

	
	
	
	
	
	
	
	
	
	
	@Then("I click on Personal Details Save")
	public void i_click_on_personal_details_save() {

	}






















}
