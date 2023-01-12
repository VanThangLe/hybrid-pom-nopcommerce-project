package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGenerator;

public class Admin extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}
	
	@Test
	public void TC_01_Search_With_Product_Name() {
		//test
	}
	
	@Test
	public void TC_02_Search_With_Product_Name_And_Parent_Category_And_Unchecked_Sub_Categories() {
		
	}
	
	@Test
	public void TC_03_Search_With_Product_Name_And_Parent_Category_And_Checked_Sub_Categories() {
		
	}
	
	@Test
	public void TC_04_Search_With_Product_Name_And_Child_Category() {
		
	}
	
	@Test
	public void TC_05_Search_With_Product_Name_And_Manufacturer() {
		
	}
	
	@Test
	public void TC_06_Go_Directly_To_Product_SKU() {
		
	}
	
	@Test
	public void TC_07_Create_New_Customer() {
		
	}
	
	@Test
	public void TC_08_Search_Customer_With_Email() {
		
	}
	
	@Test
	public void TC_09_Search_Customer_With_First_Name_And_Last_Name() {
		
	}
	
	@Test
	public void TC_10_Search_Customer_With_Company() {
		
	}
	
	@Test
	public void TC_11_Search_Customer_With_Full_Data() {
		
	}
	
	@Test
	public void TC_12_Edit_Customer() {
		
	}
	
	@Test
	public void TC_13_Add_New_Address_In_Customer_Detail() {
		
	}
	
	@Test
	public void TC_14_Edit_Address_In_Customer_Detail() {
		
	}
	
	@Test
	public void TC_15_Delete_Address_In_Customer_Detail() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
