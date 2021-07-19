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
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test
	public void TC_01_Register_With_Empty_Data() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorFieldMessage("FirstName"), "First name is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessage("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessage("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessage("Password"), "Password is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessage("ConfirmPassword"), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_With_Invalid_Email() {
		registerPage.enterToEmailTextbox("automation");
		Assert.assertEquals(registerPage.getErrorFieldMessage("Email"), "Wrong email");
	}
	
	@Test
	public void TC_03_Register_With_Exist_Email() {
		registerPage.enterToFirstNameTextbox("Automation");
		registerPage.enterToLastNameTextbox("FC");
		registerPage.enterToEmailTextbox("automationfc.hn.vn@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		registerPage.clickToLogoutLink();
		registerPage.enterToFirstNameTextbox("Automation");
		registerPage.enterToLastNameTextbox("FC");
		registerPage.enterToEmailTextbox("automationfc.hn.vn@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorFormMessage(), "The specified email already exists");
	}
	
	@Test
	public void TC_04_Register_With_Password_More_Than_6_Characters() {
		registerPage.enterToFirstNameTextbox("Automation");
		registerPage.enterToLastNameTextbox("FC");
		registerPage.enterToEmailTextbox("automationfc.hn1.vn@gmail.com");
		registerPage.enterToCompanyTextbox("Automation Testing");
		registerPage.enterToPasswordTextbox("1234");
		registerPage.enterToConfirmPasswordTextbox("1234");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorFieldMessage("Password"), "Password must meet the following rules:\n" + "must have at least 6 characters");
		homePage = registerPage.clickToLogoutLink();
	}
	
	//@Test
	public void TC_05_Register_With_Confirm_Password_Differ_Password() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderMaleRadio();
		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(day);
		registerPage.selectMonthDropdown(month);
		registerPage.selectYearDropdown(year);
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToCompanyTextbox(companyName);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
	}
	
	//@Test
	public void TC_06_Register_With_Valid_Email_And_Password() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderMaleRadio();
		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(day);
		registerPage.selectMonthDropdown(month);
		registerPage.selectYearDropdown(year);
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToCompanyTextbox(companyName);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
