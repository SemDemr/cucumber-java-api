package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {

	@FindBy(id = "first-name-box")
	public WebElement firstName;

	@FindBy(id = "middle-name-box")
	public WebElement middleName;

	@FindBy(id = "last-name-box")
	public WebElement lastName;

	@FindBy(id = "employeeId")
	public WebElement employeeId;

	@FindBy(id = "location")
	public WebElement location;

	@FindBy(css = "input#hasLoginDetails")
	public WebElement checkBoxLoginDetails;

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "confirmPassword")
	public WebElement confirmPassword;

	@FindBy(id = "modal-save-button")
	public WebElement saveBtn;

	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}
}
