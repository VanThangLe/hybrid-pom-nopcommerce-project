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
	
	@Parameters({"browserName", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-condition: Open browser '" + browserName + "'and navigate to '" + url + "'");
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test
	public void Testcase_01_Register_With_Empty_Data() {
		log.info("Testcase 01 - Step 01: Open 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Testcase 01 - Step 02: Click to 'Register' button");
		registerPage.clickToButtonByID(driver, "register-button");
		
		log.info("Testcase 01 - Step 03: Verify error message");
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "FirstName"), "First name is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "Email"), "Email is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "Password"), "Password is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "ConfirmPassword"), "Password is required.");
	}
	
	@Test
	public void Testcase_02_Register_With_Invalid_Email() {
		log.info("Testcase 02 - Step 01: Open 'Register' page");
		registerPage.refreshCurrentPage(driver);
		
		log.info("Testcase 02 - Step 02: Enter invalid Email");
		registerPage.enterToTextboxByID(driver, "Email", "automationfc.vn");
		
		log.info("Testcase 02 - Step 03: Click to 'Register' button");
		registerPage.clickToButtonByID(driver, "register-button");
		
		log.info("Testcase 01 - Step 05: Verify error message");
		Assert.assertEquals(registerPage.getErrorFieldMessageByID(driver, "Email"), "Wrong email");
	}
	
	@Test
	public void Testcase_03_Register_With_Valid_Email_And_Password() {
		log.info("Testcase 03 - Step 01: Open 'Register' page");
		registerPage.refreshCurrentPage(driver);
		
		log.info("Testcase 03 - Step 01: Open 'Register' page");
		registerPage.clickToRadioByLabel(driver, "Male");
		
		log.info("Testcase 03 - Step 01: Open 'Register' page");
		registerPage.enterToTextboxByID(driver, "FirstName", "Automation FanClub");
		
		log.info("Testcase 03 - Step 01: Open 'Register' page");
		registerPage.enterToTextboxByID(driver, "LastName", "FanClub");
		
		log.info("Testcase 03 - Step 01: Open 'Register' page");
		registerPage.enterToTextboxByID(driver, "Email", "automationfanclub.vn@gmail.com");
		
		log.info("Testcase 03 - Step 01: Open 'Register' page");
		registerPage.enterToTextboxByID(driver, "Password", "123456");
		
		log.info("Testcase 03 - Step 01: Open 'Register' page");
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", "123456");
		
		log.info("Testcase 03 - Step 01: Open 'Register' page");
		registerPage.clickToButtonByID(driver, "register-button");
		
		log.info("Testcase 03 - Step 01: Open 'Register' page");
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
		
		log.info("Testcase 03 - Step 01: Open 'Register' page");
		homePage = registerPage.logoutToSystem(driver);
	}
	
	@Test
	public void Testcase_04_Register_With_Exist_Email() {
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
	public void Testcase_05_Register_With_Password_Less_Than_6_Characters() {
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
	public void Testcase_06_Register_With_Confirm_Password_Different_Password() {
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
