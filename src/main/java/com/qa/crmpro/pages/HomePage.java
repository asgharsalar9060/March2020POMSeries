package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.utils.Constants;
import com.qa.crmpro.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	// 1. By locators -- OR

	By header = By.xpath("//td[contains(text(),'CRMPRO')]");
	By user = By.xpath("//td[contains(text(),'User: Asghar Salar')]");
	
	By contactsLink = By.xpath("//a[contains(text(),'Contacts')]");
	By newContactsLink = By.xpath("//a[contains(text(),'New Contact')]");

	// 2. Constructor of page class:

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// 3. page actions

	public String getHomePageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.Home_PAGE_TITLE, 10);
	}

	public String getHomePageHeader() {
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public String getHomePageLoggedInUser() {
		if(elementUtil.doIsDisplayed(user)) {
			return elementUtil.doGetText(user);
		}
		return null;
	}
	
	public ContactsPage goToContactsPage() {
		Constants.switchToFrame();
		clickOnNewContacts();
		return new ContactsPage(driver);
	}

	private void clickOnNewContacts() {
		elementUtil.waitForElementToBeVisible(contactsLink, 10);
		elementUtil.doClick(contactsLink);
		elementUtil.waitForElementToBeVisible(newContactsLink, 10);
		elementUtil.doClick(newContactsLink);
	}
	
	
	
	
	
	
	
	
}
