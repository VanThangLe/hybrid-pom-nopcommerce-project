package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public boolean isRegisterSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
	}
}
