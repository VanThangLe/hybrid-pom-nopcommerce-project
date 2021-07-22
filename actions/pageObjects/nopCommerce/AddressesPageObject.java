package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.AddressesPageUI;

public class AddressesPageObject extends BasePage{
	WebDriver driver;
	
	public AddressesPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickAble(driver, AddressesPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AddressesPageUI.ADD_NEW_ADDRESS_BUTTON);
	}

	public void addAddressFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AddressesPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void addAddressLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AddressesPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void addAddressEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, AddressesPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void addAddressCompanyTextbox(String companyName) {
		waitForElementVisible(driver, AddressesPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.FIRST_NAME_TEXTBOX, companyName);
	}

	public void addAddressCountryDropdown(String countryName) {
		waitForElementClickAble(driver, AddressesPageUI.COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AddressesPageUI.COUNTRY_DROPDOWN, countryName);
	}

	public void addAddressStateProvinceDropdown(String stateProvinceName) {
		waitForElementClickAble(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWN);
		selectItemInDefaultDropdown(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWN, stateProvinceName);
	}

	public void addAddressCityTextbox(String cityName) {
		waitForElementVisible(driver, AddressesPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.CITY_TEXTBOX, cityName);
	}

	public void addAddressAddress1Textbox(String address1) {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS1_TEXTBOX, address1);
	}

	public void addAddressAddress2Textbox(String address2) {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS2_TEXTBOX, address2);
	}

	public void addAddressZipPostalCodeTextbox(String zipPostalCode) {
		waitForElementVisible(driver, AddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
	}

	public void addAddressPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, AddressesPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void addAddressFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, AddressesPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToSaveAddressButton() {
		waitForElementClickAble(driver, AddressesPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AddressesPageUI.SAVE_ADDRESS_BUTTON);
	}

	public String getAddressFullNameValue() {
		waitForElementVisible(driver, AddressesPageUI.FULL_NAME_VALUE);
		return getElementText(driver, AddressesPageUI.FULL_NAME_VALUE);
	}

	public String getAddressEmailValue() {
		waitForElementVisible(driver, AddressesPageUI.EMAIL_VALUE);
		return getElementText(driver, AddressesPageUI.EMAIL_VALUE);
	}

	public String getAddressCompanyValue() {
		waitForElementVisible(driver, AddressesPageUI.COMPANY_VALUE);
		return getElementText(driver, AddressesPageUI.COMPANY_VALUE);
	}

	public String getAddressCountryValue() {
		waitForElementVisible(driver, AddressesPageUI.COUNTRY_VALUE);
		return getElementText(driver, AddressesPageUI.COUNTRY_VALUE);
	}

	public String getAddressCityValue() {
		waitForElementVisible(driver, AddressesPageUI.CITY_STATE_ZIP_CODE_VALUE);
		return getElementText(driver, AddressesPageUI.CITY_STATE_ZIP_CODE_VALUE);
	}

	public String getAddressAddress1Value() {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS1_VALUE);
		return getElementText(driver, AddressesPageUI.ADDRESS1_VALUE);
	}

	public String getAddressAddress2Value() {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS2_VALUE);
		return getElementText(driver, AddressesPageUI.ADDRESS2_VALUE);
	}

	public String getAddressPhoneNumberValue() {
		waitForElementVisible(driver, AddressesPageUI.PHONE_VALUE);
		return getElementText(driver, AddressesPageUI.PHONE_VALUE);
	}

	public String getAddressFaxNumberValue() {
		waitForElementVisible(driver, AddressesPageUI.FAX_VALUE);
		return getElementText(driver, AddressesPageUI.FAX_VALUE);
	}
}
