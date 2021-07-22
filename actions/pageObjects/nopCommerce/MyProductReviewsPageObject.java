package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.MyProductReviewsPageUI;

public class MyProductReviewsPageObject extends BasePage{
	WebDriver driver;
	
	public MyProductReviewsPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public String getMyProductTitleValue() {
		waitForElementVisible(driver, MyProductReviewsPageUI.PRODUCT_REVIEW_TITLE_VALUE);
		return getElementText(driver, MyProductReviewsPageUI.PRODUCT_REVIEW_TITLE_VALUE);
	}
}
