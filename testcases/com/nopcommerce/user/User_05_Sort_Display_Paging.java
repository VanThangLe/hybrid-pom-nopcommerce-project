package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGenerator;

public class User_05_Sort_Display_Paging extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test
	public void TC_01_Sort_With_Name_A_To_Z() {
		
	}
	
	@Test
	public void TC_02_Sort_With_Name_Z_To_A() {
		
	}
	
	@Test
	public void TC_03_Sort_With_Price_Low_To_High() {
		
	}
	
	@Test
	public void TC_04_Sort_With_Price_High_To_Low() {
		
	}
	
	@Test
	public void TC_05_Display_With_3_Product_Per_Page() {
		
	}
	
	@Test
	public void TC_06_Display_With_6_Product_Per_Page() {
		
	}
	
	@Test
	public void TC_07_Display_With_9_Product_Per_Pager() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
