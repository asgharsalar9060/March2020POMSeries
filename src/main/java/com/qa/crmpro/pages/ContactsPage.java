package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.utils.Constants;
import com.qa.crmpro.utils.ElementUtil;

public class ContactsPage extends BasePage {
	
	private WebDriver driver;

	 //1. By locators:
	By contactsLink = By.xpath("//a[contains(text(),'Contacts')]");
	By newContactsLink = By.xpath("//a[contains(text(),'New Contact')]");
	By title = By.xpath("//select[@name='title']");
	By header = By.xpath("//td[contains(text(),'CRMPRO')]");
	By firstName = By.xpath("//input[@id='first_name']");
	By lastName = By.xpath("//input[@id='surname']");
	By saveButton = By.xpath("(//input[@type='submit' and @value='Save'])[last()]");
	
	//2. page class constructor:
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	//3. page actions:
	
	public String getContactsPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 10);
	}
	
	public String getContactsPageHeader() {
		elementUtil.waitForElementToBeVisible(header, 10);
		return elementUtil.doGetText(header);
	}
	
	public void createNewContact(String title, String firstName, String lastName) {
		elementUtil.waitForElementToBeVisible(contactsLink, 10);
		elementUtil.doClick(newContactsLink);
		
		elementUtil.doSelectByVisibleText(this.title, title);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doClick(saveButton);
		
		//elementUtil.clickWhenReady(contactsLink, 5);
	}
	
	
	
}
