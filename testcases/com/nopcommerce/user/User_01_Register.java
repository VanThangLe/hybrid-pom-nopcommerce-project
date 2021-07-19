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
	
	//@Test
	public void TC_01_Register_With_Empty_Data() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessage("FirstName"), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessage("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessage("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessage("Password"), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessage("ConfirmPassword"), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_With_Invalid_Email() {
		registerPage.enterToEmailTextbox("a");
		Assert.assertEquals(registerPage.getErrorMessage("Email"), "Wrong email");
	}
	
	//@Test
	public void TC_03_Register_With_Exist_Email() {
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
	public void TC_04_Register_With_Password_More_Than_6_Characters() {
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
