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
import pageObjects.nopCommerce.ProductDetailPageObject;
import pageObjects.nopCommerce.ProductReviewPageObject;
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
	ProductDetailPageObject productDetailPage;
	ProductReviewPageObject productReviewPage;
	
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
		registerPage.enterToFirstNameTextbox("Automation");
		registerPage.enterToLastNameTextbox("FC");
		registerPage.enterToEmailTextbox("automationfc.vn@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox("automationfc.vn@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		homePage = loginPage.clickToLoginButton();
		customerInfoPage = homePage.clickToMyAccountLink();
		customerInfoPage.updateGenderRadio("female");
		customerInfoPage.updateFirstNameTextbox("Automation");
		customerInfoPage.updateLastNameTextbox("FC");
		customerInfoPage.updateDayDropdown("1");
		customerInfoPage.updateMonthDropdown("January");
		customerInfoPage.updateYearDropdown("1999");
		customerInfoPage.updateEmailTextbox("automationfc.vn@gmail.com");
		customerInfoPage.updateCompanyTextbox("Automation FC");
		customerInfoPage.clickToSaveCustomerInfoButton();
		Assert.assertTrue(customerInfoPage.isGenderRadioSelected("female"));
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "Automation");
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), "FC");
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), "automationfc.vn@gmail.com");
		Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), "Automation FC");
		Assert.assertEquals(customerInfoPage.getDayDropdownValue(), "1");
		Assert.assertEquals(customerInfoPage.getMonthDropdownValue(), "January");
		Assert.assertEquals(customerInfoPage.getYearDropdownValue(), "1999");
	}
	
	@Test
	public void TC_02_Add_Address() {
		addressesPage = PageGenerator.getAddressesPage(driver);
		addressesPage.clickToAddNewButton();
		addressesPage.addAddressFirstNameTextbox("Automation");
		addressesPage.addAddressLastNameTextbox("FC");
		addressesPage.addAddressEmailTextbox("automationfc.vn@gmail.com");
		addressesPage.addAddressCompanyTextbox("Automation FC");
		addressesPage.addAddressCountryDropdown("Viet Nam");
		addressesPage.addAddressStateProvinceDropdown("Other");
		addressesPage.addAddressCityTextbox("Da Nang");
		addressesPage.addAddressAddress1Textbox("123/04 Le Lai");
		addressesPage.addAddressAddress2Textbox("234/05 Hai Phong");
		addressesPage.addAddressZipPostalCodeTextbox("550000");
		addressesPage.addAddressPhoneNumberTextbox("0123456789");
		addressesPage.addAddressFaxNumberTextbox("0987654321");
		addressesPage.clickToSaveAddressButton();
		Assert.assertEquals(addressesPage.getAddressFullNameValue(), "Automation FC");
		Assert.assertEquals(addressesPage.getAddressEmailValue(), "Email: automationfc.vn@gmail.com");
		Assert.assertEquals(addressesPage.getAddressCompanyValue(), "Automation FC");
		Assert.assertEquals(addressesPage.getAddressCountryValue(), "Viet Nam");
		Assert.assertEquals(addressesPage.getAddressCityValue(), "Da Nang, 550000");
		Assert.assertEquals(addressesPage.getAddressAddress1Value(), "123/04 Le Lai");
		Assert.assertEquals(addressesPage.getAddressAddress2Value(), "234/05 Hai Phong");
		Assert.assertEquals(addressesPage.getAddressPhoneNumberValue(), "Phone number: 0123456789");
		Assert.assertEquals(addressesPage.getAddressFaxNumberValue(), "Fax number: 0987654321");
	}
	
	@Test
	public void TC_03_Change_Password() {
		changePasswordPage = PageGenerator.getChangePasswordPage(driver);
		changePasswordPage.enterToOldPasswordTextbox("123456");
		changePasswordPage.enterToNewPasswordTextbox("654321");
		changePasswordPage.enterToConfirmNewPasswordTextbox("654321");
		changePasswordPage.clickToChangePasswordButton();
		Assert.assertEquals(changePasswordPage.getBarNotificationSuccess(), "Password was changed");
		changePasswordPage.clickToCloseNotificationButton();
		loginPage = changePasswordPage.clickToLogoutLink();
		loginPage.enterToEmailTextbox("automationfc.vn@gmail.com");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorFormMessageLogin(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
		loginPage.enterToEmailTextbox("automationfc.vn@gmail.com");
		loginPage.enterToPasswordTextbox("654321");
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isTopicBlockTitleDisplayed());
	}
	
	@Test
	public void TC_04_Add_Product_Reviews() {
		productDetailPage = homePage.clickToTitleProduct("Build your own computer");
		productReviewPage = productDetailPage.clickToAddReviewLink();
		productReviewPage.enterToReviewTitleTextbox("Computer Case");
		productReviewPage.enterToReviewTextTextbox("Fast");
		productReviewPage.clickToRatingRadio("5");
		productReviewPage.clickToSubmitReviewButton();
		Assert.assertTrue(productReviewPage.isProductReviewAdded());
		customerInfoPage = productReviewPage.clickToMyAccountLink();
		myProductReviewsPage = PageGenerator.getMyProductReviewsPage(driver);
		Assert.assertEquals(myProductReviewsPage.getMyProductTitleValue(), "Build your own computer");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
