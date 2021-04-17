package com.qa.crmpro.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BaseTest;
import com.qa.crmpro.pages.ContactsPage;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.utils.Constants;
import com.qa.crmpro.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest{
	
	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeClass
	public void contactsSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}
	
	@Test(priority=1)
	public void verifyContactsPageTitleTest() {
		
		String title = contactsPage.getContactsPageTitle();
		System.out.println("Contacts page title is: "+title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CONTACT_SHEET_NAME);
		return data;
	}
	
	@Test(priority=2, dataProvider = "getContactsTestData")
	public void createContactsTest(String title, String firstName, String lastName) {
		
		contactsPage.createNewContact(title, firstName, lastName);
	}
	
	
	
	
	
	

}
