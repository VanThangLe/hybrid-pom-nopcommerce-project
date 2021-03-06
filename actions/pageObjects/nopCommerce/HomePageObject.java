package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickAble(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGenerator.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickAble(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGenerator.getLoginPage(driver);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickAble(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGenerator.getCustomerInforPage(driver);
	}
	
	public boolean isTopicBlockTitleDisplayed() {
		waitForElementVisible(driver, HomePageUI.TOPIC_BLOCK_TITLE);
		return isElementDisplayed(driver, HomePageUI.TOPIC_BLOCK_TITLE);
	}

	public ProductDetailPageObject clickToTitleProduct(String productTitle) {
		waitForElementVisible(driver, HomePageUI.PRODUCT_TITLE, productTitle);
		clickToElement(driver, HomePageUI.PRODUCT_TITLE, productTitle);
		return PageGenerator.getProductDetailPage(driver);
	}
}
