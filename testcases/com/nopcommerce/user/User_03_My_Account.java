package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.AddressesPageObject;
import pageObjects.nopCommerce.ChangePasswordPageObject;
import pageObjects.nopCommerce.CustomerInfoPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyProductReviewsPageObject;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.RegisterPageObject;

public class User_03_My_Account extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	CustomerInfoPageObject customerInfoPage;
	AddressesPageObject addressesPage;
	ChangePasswordPageObject changePasswordPage;
	MyProductReviewsPageObject myProductReviewsPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test
	public void TC_01_Update_Customer_Info() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderRadio("male");
		registerPage.enterToFirstNameTextbox("Thang");
		registerPage.enterToLastNameTextbox("Le Van");
		registerPage.selectDayDropdown("07");
		registerPage.selectMonthDropdown("July");
		registerPage.selectYearDropdown("1996");
		registerPage.enterToEmailTextbox("thanglv@gmail.com");
		registerPage.enterToCompanyTextbox("Automation Testing");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		homePage = registerPage.clickToLogoutLink();
		
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox("thanglv@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		homePage = loginPage.clickToLoginButton();
		
		customerInfoPage = homePage.clickToMyAccountLink();
		customerInfoPage.updateGenderRadio("female");
		customerInfoPage.updateFirstNameTextbox("Automation");
		customerInfoPage.updateLastNameTextbox("FC");
		customerInfoPage.updateDayDropdown("01");
		customerInfoPage.updateMonthDropdown("January");
		customerInfoPage.updateYearDropdown("1999");
		customerInfoPage.updateEmailTextbox("automationfc.vn@gmail.com");
		customerInfoPage.updateCompanyTextbox("Automation FC");
		customerInfoPage.clickSaveButton();
		Assert.assertTrue(customerInfoPage.isGenderRadioSelected("female"));
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "Automation");
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), "FC");
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "automationfc.vn@gmail.com");
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "Automation FC");
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "01");
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "January");
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "1999");
	}
	
	@Test
	public void TC_02_Add_Address() {
		
	}
	
	@Test
	public void TC_03_Change_Password() {
		
	}
	
	@Test
	public void TC_04_Add_Product_Reviews() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
