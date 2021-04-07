package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;

public class HomePage extends BasePage {

	private WebDriver driver;

	// 1. By locators -- OR

	By header = By.xpath("//td[contains(text(),'CRMPRO')]");
	By user = By.xpath("//td[contains(text(),'User: Asghar Salar')]");

	// 2. Constructor of page class:

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public String getHomePageHeader() {
		if (driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
		}
		return null;
	}

	public String getHomePageLoggedInUser() {
		if (driver.findElement(user).isDisplayed()) {
			return driver.findElement(user).getText();
		}
		return null;
	}

}
