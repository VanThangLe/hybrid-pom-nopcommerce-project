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

public class User_04_Search_Advanced_Search extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test
	public void TC_01_Search_With_Empty_Data() {
		
	}
	
	@Test
	public void TC_02_Search_With_Data_Not_Exist() {
		
	}
	
	@Test
	public void TC_03_Search_With_Product_Name_RelativeLy() {
		
	}
	
	@Test
	public void TC_04_Search_With_Product_Name_Absolutely() {
		
	}
	
	@Test
	public void TC_05_Advanced_Search_With_Parent_Categories() {
		
	}
	
	@Test
	public void TC_06_Advanced_Search_With_Sub_Categories() {
		
	}
	
	@Test
	public void TC_07_Advanced_Search_With_Incorrect_Manufacturer() {
		
	}
	
	@Test
	public void TC_08_Advanced_Search_With_Correct_Manufacturer() {
		
	}
	
	@Test
	public void TC_09_Advanced_Search_In_Price_Range() {
		
	}
	
	@Test
	public void TC_10_Advanced_Search_With_Price_Range_Lower_Than_Product_Price() {
		
	}
	
	@Test
	public void TC_11_Advanced_Search_With_Price_Range_Higher_Than_Product_Price() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
