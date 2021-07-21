package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	private WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public boolean isGenderRadioSelected(String gender) {
		waitForElementVisible(driver, CustomerInfoPageUI.GENDER_RADIO, gender);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_RADIO, gender);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getDayDropdownValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
	}

	public String getMonthDropdownValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getYearDropdownValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}
	
	public void updateGenderRadio(String gender) {
		waitForElementClickAble(driver, CustomerInfoPageUI.GENDER_RADIO, gender);
		clickToElement(driver, CustomerInfoPageUI.GENDER_RADIO, gender);
	}
	
	public void updateFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, firstName);
	}
	
	public void updateLastNameTextbox(String lastName) {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, lastName);
	}
	
	public void updateEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	public void updateCompanyTextbox(String companyName) {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, companyName);
	}
	
	public void updateDayDropdown(String day) {
		waitForElementVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN, day);
	}
	
	public void updateMonthDropdown(String month) {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN, month);
	}
	
	public void updateYearDropdown(String year) {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN, year);
	}
	
	public void clickSaveButton() {
		waitForElementClickAble(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}
}
