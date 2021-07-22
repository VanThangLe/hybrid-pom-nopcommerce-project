package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.MyProductReviewsPageUI;

public class MyProductReviewsPageObject extends BasePage{
	WebDriver driver;
	
	public MyProductReviewsPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public String getMyProductReviewText() {
		waitForElementVisible(driver, MyProductReviewsPageUI.REVIEW_TEXT_VALUE);
		return getElementText(driver, MyProductReviewsPageUI.REVIEW_TEXT_VALUE);
	}

	public String getMyProductReviewTitle() {
		waitForElementVisible(driver, MyProductReviewsPageUI.REVIEW_TITLE_VALUE);
		return getElementText(driver, MyProductReviewsPageUI.REVIEW_TITLE_VALUE);
	}
}
