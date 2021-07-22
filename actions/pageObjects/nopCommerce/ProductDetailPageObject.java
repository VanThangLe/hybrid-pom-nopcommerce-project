package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ProductReviewPageUI;

public class ProductDetailPageObject extends BasePage{
	private WebDriver driver;
	
	public ProductDetailPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public ProductReviewPageObject clickToAddReviewLink() {
		waitForElementClickAble(driver, ProductReviewPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, ProductReviewPageUI.ADD_REVIEW_LINK);
		return PageGenerator.getProductReviewPage(driver);
	}
}
