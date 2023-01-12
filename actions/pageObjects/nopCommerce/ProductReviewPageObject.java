package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ProductReviewPageUI;

public class ProductReviewPageObject extends BasePage{
	private WebDriver driver;
	
	public ProductReviewPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public boolean isProductReviewAdded() {
		// TODO Auto-generated method stub
		return false;
	}

	public void enterToReviewTitleTextbox(String titleReview) {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, ProductReviewPageUI.REVIEW_TITLE_TEXTBOX, titleReview);
	}

	public void enterToReviewTextTextbox(String textReview) {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TEXT_TEXTBOX);
		sendkeyToElement(driver, ProductReviewPageUI.REVIEW_TEXT_TEXTBOX, textReview);
	}

	public void clickToRatingRadio(String rating) {
		waitForElementClickAble(driver, ProductReviewPageUI.RATING_RADIO, rating);
		clickToElement(driver, ProductReviewPageUI.RATING_RADIO, rating);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickAble(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickAble(driver, ProductReviewPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, ProductReviewPageUI.MY_ACCOUNT_LINK);
		return PageGenerator.getCustomerInfoPage(driver);
	}
}
