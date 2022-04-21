package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGenerator;

public class User_02_Login extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test
	public void TC_01_Login_With_Empty_Data() {
		loginPage = homePage.clickToLoginLink();
		loginPage.loginToSystem(driver, "", "");
		
		Assert.assertEquals(loginPage.getErrorFieldMessageByID(driver, "Email"), "Please enter your email");
	}
	
	@Test
	public void TC_02_Login_With_Invalid_Email() {
		loginPage.loginToSystem(driver, "automationfc@gmail.com", "");
		
		Assert.assertEquals(loginPage.getErrorFieldMessageByID(driver, "Email"), "Wrong email");
	}
	
	@Test
	public void TC_03_Login_With_Not_Registered_Email() {
		loginPage.loginToSystem(driver, "automationfc@gmail.com", "123abc");
		
		Assert.assertEquals(loginPage.getErrorFormMessage(driver), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}
	
	@Test
	public void TC_04_Login_With_Blank_Password() {
		loginPage.loginToSystem(driver, "automationfc1.vn@gmail.com", "");
		
		Assert.assertEquals(loginPage.getErrorFormMessage(driver), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}
	
	@Test
	public void TC_05_Login_With_Invalid_Password() {
		loginPage.loginToSystem(driver, "automationfc1.vn@gmail.com", "12");
		
		Assert.assertEquals(loginPage.getErrorFormMessage(driver), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}
	
	@Test
	public void TC_06_Login_With_Valid_Email_And_Password() {
		homePage = loginPage.loginToSystem(driver, "automationfanclub.vn@gmail.com", "123456");
		
		Assert.assertTrue(homePage.isTopicBlockTitleDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
