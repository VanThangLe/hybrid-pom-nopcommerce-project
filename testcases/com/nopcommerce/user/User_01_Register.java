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
		Assert.assertEquals(registerPage.getErrorFieldMessageRegister("FirstName"), "First name is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageRegister("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageRegister("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageRegister("Password"), "Password is required.");
		Assert.assertEquals(registerPage.getErrorFieldMessageRegister("ConfirmPassword"), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_With_Invalid_Email() {
		registerPage.enterToEmailTextbox("thanglv");
		Assert.assertEquals(registerPage.getErrorFieldMessageRegister("Email"), "Wrong email");
	}
	
	@Test
	public void TC_03_Register_With_Valid_Email_And_Password() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderRadio("male");
		registerPage.enterToFirstNameTextbox("Thang");
		registerPage.enterToLastNameTextbox("Le Van");
		registerPage.selectDayDropdown("07");
		registerPage.selectMonthDropdown("July");
		registerPage.selectYearDropdown("1996");
		registerPage.enterToEmailTextbox("thanglv@hotmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
	}
	
	@Test
	public void TC_04_Register_With_Exist_Email() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox("Thang");
		registerPage.enterToLastNameTextbox("Le Van");
		registerPage.enterToEmailTextbox("thanglv@hotmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorFormMessageRegister(), "The specified email already exists");
	}
	
	@Test
	public void TC_05_Register_With_Password_More_Than_6_Characters() {
		registerPage.enterToFirstNameTextbox("Thang");
		registerPage.enterToLastNameTextbox("Le Van");
		registerPage.enterToEmailTextbox("thanglevan@yahoo.com");
		registerPage.enterToPasswordTextbox("1234");
		registerPage.enterToConfirmPasswordTextbox("1234");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorFieldMessageRegister("Password"), "Password must meet the following rules:\n" + "must have at least 6 characters");
	}
	
	@Test
	public void TC_06_Register_With_Confirm_Password_Differ_Password() {
		registerPage.enterToFirstNameTextbox("Thang");
		registerPage.enterToLastNameTextbox("Le Van");
		registerPage.enterToEmailTextbox("thanglevan@yahoo.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123abc");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorFieldMessageRegister("ConfirmPassword"), "The password and confirmation password do not match.");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
