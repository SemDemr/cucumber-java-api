package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.CommonMethods;

public class PersonalDetailsPageElements extends CommonMethods {

	@FindBy(id = "pimPersonalDetailsForm")
	public WebElement personalDetailsForm;

	@FindBy(id = "employeeId")
	public WebElement employeeId;
	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement employeeName;
	
	@FindBy(id = "smoker")
	public WebElement smoker;
	@FindBy(xpath = "//label[text()='Smoker']")
	public WebElement smokerBox;

	@FindBy(id = "nation_code")
	public WebElement nation;
	
	@FindBy(id = "licenseNo")
	public WebElement driverLicense;
	@FindBy(id = "P1515221768_root")
	public WebElement exDcal;
	@FindBy(id = "emp_gender")
	public WebElement gender;
	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']/div/input")
	public WebElement genderInput;
	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']/div/ul/li")
	public List<WebElement> genderOptions;
	
	@FindBy(xpath="//div[@class='select-wrapper picker__select--year']")
	public WebElement year;
	
	@FindBy(xpath="//div[@class='select-wrapper picker__select--month']")
	public WebElement month;

	public PersonalDetailsPageElements() {
		PageFactory.initElements(driver, this);
	}
}
