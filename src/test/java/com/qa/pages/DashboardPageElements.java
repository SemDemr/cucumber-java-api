package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageElements extends com.qa.utils.CommonMethods {

	@FindBy(xpath = "//span[@id='account-name']")
	public WebElement accountName;

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement PIM;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmployeeLink;

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

	@FindBy(linkText = "Employee List")
	public WebElement employeeListLink;

	@FindBy(id = "account-job")
	public WebElement accountMenu;

	@FindBy(id = "logoutLink")
	public WebElement logout;
	@FindBy(xpath = "//div[@id='menu-content']/ul/li")
	public List<WebElement> menuList;

	@FindBy(xpath = "//li[@id='menu_news_More']")
	public WebElement moreMenuItem;

	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}

}
