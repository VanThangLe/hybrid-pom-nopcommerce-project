package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGenerator;

public class User_07_Order extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test
	public void TC_01_Add_Product_To_Cart() {
		
	}
	
	@Test
	public void TC_02_Edit_Product_In_Shopping_Cart() {
		
	}
	
	@Test
	public void TC_03_Remove_From_Cart() {
		
	}
	
	@Test
	public void TC_04_Update_Shopping_Cart() {
		
	}
	
	@Test
	public void TC_05_Checkout_Order_Payment_Method_By_Cheque() {
		
	}
	
	@Test
	public void TC_06_Checkout_Order_Payment_Method_By_Card() {
		
	}
	
	@Test
	public void TC_07_Re_Order() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
