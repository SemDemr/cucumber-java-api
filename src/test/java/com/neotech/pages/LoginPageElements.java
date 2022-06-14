package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.ConfigsReader;

public class LoginPageElements extends com.neotech.utils.CommonMethods {

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(css = "button[type='submit']")
	public WebElement logInButton;

	@FindBy(xpath = "//span[@id='txtPassword-error']")
	public WebElement errorEmptyPassword;

	@FindBy(xpath = "//div[@id='toast-container']/div/div")
	public WebElement errorInvalidPassword;

	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}

	public void signIn() {
		sendText(username, ConfigsReader.getProperty("username"));

		wait(1);
		sendText(password, ConfigsReader.getProperty("password"));
		wait(1);

		jsClick(logInButton);
		wait(2);

	}

}
