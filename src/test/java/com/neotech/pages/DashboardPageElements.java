package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageElements extends com.neotech.utils.CommonMethods {

	@FindBy(xpath="//span[@id='account-name']")
	public WebElement accountName;
	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement pim;

	@FindBy(linkText = "Add Employee")
	public WebElement addEmployee;

	@FindBy(id = "first-name-box")
	public WebElement firstName;

	@FindBy(id = "last-name-box")
	public WebElement lastName;

	@FindBy(id = "employeeId")
	public WebElement empID;

	@FindBy(id = "location")
	public WebElement location;

	@FindBy(id = "hasLoginDetails")
	public WebElement swBtn;

	@FindBy(id = "username")
	public WebElement userName;

	@FindBy(id = "password")
	public WebElement password;
	@FindBy(id = "confirmPassword")
	public WebElement cPassword;

	@FindBy(id = "modal-save-button")
	public WebElement saveBtn;

	@FindBy(id = "personal_details_tab")
	public WebElement personalDts;

	
	public DashboardPageElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	
}
