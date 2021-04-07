package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;

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
	}

	// 3. Page actions:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean verifySignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}

	public HomePage doLogin(String username, String password) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();

		return new HomePage(driver);
	}
}
