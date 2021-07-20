package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver) {
		this.driver = _driver;
	}
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getHomePage(driver);
	}
	public String getErrorFieldMessageLogin(String fieldName) {
		waitForElementVisible(driver, LoginPageUI.ERROR_FIELD_MESSAGE_LOGIN, fieldName);
		return getElementText(driver, LoginPageUI.ERROR_FIELD_MESSAGE_LOGIN, fieldName);
	}
	public String getErrorFormMessageLogin() {
		waitForElementVisible(driver, LoginPageUI.ERROR_FORM_MESSAGE_LOGIN);
		return getElementText(driver, LoginPageUI.ERROR_FORM_MESSAGE_LOGIN);
	}
	public boolean isTopicBlockTitleDisplayed() {
		waitForElementVisible(driver, LoginPageUI.TOPIC_BLOCK_TITLE);
		return isElementDisplayed(driver, LoginPageUI.TOPIC_BLOCK_TITLE);
	}

}
