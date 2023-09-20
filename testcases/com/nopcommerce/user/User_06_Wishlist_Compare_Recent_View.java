package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGenerator;

public class User_06_Wishlist_Compare_Recent_View extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test
	public void TC_01_Add_To_Wishlist() {
		
	}
	
	@Test
	public void TC_02_Add_Product_To_Cart_From_Wishlist_Page() {
		
	}
	
	@Test
	public void TC_03_Remove_Product_In_Wishlist_Page() {
		
	}
	
	@Test
	public void TC_04_Add_Product_To_Compare() {
		
	}
	
	@Test
	public void TC_05_Recently_Viewed_Products() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
