package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ChangePasswordPageUI;

public class ChangePasswordPageObject extends BasePage{
	WebDriver driver;
	
	public ChangePasswordPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public void enterToOldPasswordTextbox(String oldPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD);
		sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD, oldPassword);
	}

	public void enterToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD);
		sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD, newPassword);
	}

	public void enterToConfirmNewPasswordTextbox(String confirmNewPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD);
		sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD, confirmNewPassword);
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
