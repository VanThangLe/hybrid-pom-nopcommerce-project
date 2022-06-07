package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage{
	WebDriver driver;
	
	public ChangePasswordPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public void clickToChangePasswordButton() {
		waitForElementClickAble(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getBarNotificationSuccess() {
		waitForElementVisible(driver, ChangePasswordPageUI.BAR_NOTIFICATION_SUCCESS_MESSAGE);
		return getElementText(driver, ChangePasswordPageUI.BAR_NOTIFICATION_SUCCESS_MESSAGE);
	}

	public LoginPageObject clickToLogoutLink() {
		waitForElementClickAble(driver, ChangePasswordPageUI.LOGOUT_LINK);
		clickToElement(driver, ChangePasswordPageUI.LOGOUT_LINK);
		return PageGenerator.getLoginPage(driver);
	}

	public void clickToCloseNotificationButton() {
		waitForElementClickAble(driver, ChangePasswordPageUI.CLOSE_NOTIFICATION_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_NOTIFICATION_BUTTON);
	}
}
