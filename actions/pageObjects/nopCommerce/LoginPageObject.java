package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public HomePageObject clickToButtonByLabel(String buttonLabel) {
		waitForElementClickAble(driver, LoginPageUI.DYNAMIC_BUTTON, buttonLabel);
		clickToElement(driver, LoginPageUI.DYNAMIC_BUTTON, buttonLabel);
		return PageGenerator.getHomePage(driver);
	}
}
