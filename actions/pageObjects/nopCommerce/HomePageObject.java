package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public boolean isTopicBlockTitleDisplayed() {
		waitForElementVisible(driver, HomePageUI.TOPIC_BLOCK_TITLE);
		return isElementDisplayed(driver, HomePageUI.TOPIC_BLOCK_TITLE);
	}
}
