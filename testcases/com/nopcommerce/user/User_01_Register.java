package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.RegisterPageObject;

public class User_01_Register extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String email, password;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-condition: Open browser '" + browserName + "'and navigate to '" + url + "'");
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test
	public void TC_01_Register_With_Empty_Data() {
		log.info("Testcase 1 - Step 01: Open 'Employee List' page");
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToButtonByID(driver, "register-button");
		
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "FirstName"), "First name is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "Email"), "Email is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "Password"), "Password is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "ConfirmPassword"), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_With_Invalid_Email() {
		registerPage.refreshCurrentPage(driver);
		registerPage.enterToTextboxByID(driver, "Email", "automationfc.vn");
		registerPage.clickToButtonByID(driver, "register-button");
		
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "Email"), "Wrong email");
	}
	
	@Test
	public void TC_03_Register_With_Valid_Email_And_Password() {
		registerPage.refreshCurrentPage(driver);
		registerPage.clickToRadioByLabel(driver, "Male");
		registerPage.enterToTextboxByID(driver, "FirstName", "Automation FanClub");
		registerPage.enterToTextboxByID(driver, "LastName", "FanClub");
		registerPage.enterToTextboxByID(driver, "Email", "automationfanclub.vn@gmail.com");
		registerPage.enterToTextboxByID(driver, "Password", "123456");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", "123456");
		registerPage.clickToButtonByID(driver, "register-button");
		
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
		homePage = registerPage.logoutToSystem(driver);
	}
	
	@Test
	public void TC_04_Register_With_Exist_Email() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToTextboxByID(driver, "FirstName", "Automation");
		registerPage.enterToTextboxByID(driver, "LastName", "FC");
		registerPage.enterToTextboxByID(driver, "Email", "automationfc1.vn@gmail.com");
		registerPage.enterToTextboxByID(driver, "Password", "123456");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", "123456");
		registerPage.clickToButtonByID(driver, "register-button");
		
		Assert.assertEquals(registerPage.getErrorFormMessage(driver), "The specified email already exists");
	}
	
	@Test
	public void TC_05_Register_With_Password_Less_Than_6_Characters() {
		registerPage.refreshCurrentPage(driver);
		registerPage.enterToTextboxByID(driver, "FirstName", "Automation");
		registerPage.enterToTextboxByID(driver, "LastName", "FC");
		registerPage.enterToTextboxByID(driver, "Email", "automationfc1.vn@gmail.com");
		registerPage.enterToTextboxByID(driver, "Password", "1234");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", "1234");
		registerPage.clickToButtonByID(driver, "register-button");
		
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "Password"), "Password must meet the following rules:\n" + "must have at least 6 characters");
	}
	
	@Test
	public void TC_06_Register_With_Confirm_Password_Different_Password() {
		registerPage.refreshCurrentPage(driver);
		registerPage.enterToTextboxByID(driver, "FirstName", "Automation");
		registerPage.enterToTextboxByID(driver, "LastName", "FC");
		registerPage.enterToTextboxByID(driver, "Email", "automationfc1.vn@gmail.com");
		registerPage.enterToTextboxByID(driver, "Password", "123456");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", "123abc");
		registerPage.clickToButtonByID(driver, "register-button");
		
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "ConfirmPassword"), "The password and confirmation password do not match.");
	}
	
	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}
}
