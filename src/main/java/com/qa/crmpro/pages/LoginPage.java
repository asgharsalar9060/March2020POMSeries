package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.utils.Constants;
import com.qa.crmpro.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	private WebDriver driver;

	// 1. By locators -- OR
	By username = By.name("username");
	By password = By.name("password");
	By loginButton = By.xpath("//input[@type='submit']");
	By signUpLink = By.linkText("Sign Up");

	// 2. Create constructor of page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 3. Page actions:
	@Step("Get login page title...")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}

	@Step("Check sign up line on login page...")
	public boolean verifySignUpLink() {
		return elementUtil.doIsDisplayed(signUpLink);
	}

	@Step("Login to app with username: {0} and password: {1}")
	public HomePage doLogin(String username, String password) {
		elementUtil.waitForElementToBeVisible(this.username, 10);
		elementUtil.doSendKeys(this.username, username);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doClick(this.loginButton);

		return new HomePage(driver);
	}
}
