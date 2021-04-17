package com.qa.crmpro.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BaseTest;
import com.qa.crmpro.listeners.TestAllureListener;
import com.qa.crmpro.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(TestAllureListener.class)
@Epic("Epic - 101 : design login page with different features...")
@Story("US - 102 : design basic login page signup, title and login form...")
public class LoginPageTest extends BaseTest{


	@Test(priority = 1)
	@Description("Verify login page title test...")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page title does not match");
	}

	@Test(priority = 2)
	@Description("Verify sign up link test...")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed");
	}

	@Test(priority = 3)
	@Description("Do login test...")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
