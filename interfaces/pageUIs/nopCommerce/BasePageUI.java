package pageUIs.nopCommerce;

public class BasePageUI {
	public static final String DYNAMIC_SIDE_BAR_PAGE_LINK = "//div[@class='listbox']//a[text()='%s']";
	public static final String TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String BUTTON_BY_ID = "//button[@id='%s']";
	public static final String RADIO_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";
	public static final String DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String CHECKBOX_BY_LABEL = "//label[text()='%s']/following-sibling::input";
	public static final String TABLE_HEADER_BY_ID_AND_NAME = "//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX = "//table[@id='%s']/tbody/tr[%s]/td[%s]";
	public static final String ANY_FIELD_BY_ID = "//*[@id='%s']";
	public static final String ERROR_FIELD_MESSAGE_REGISTER_BY_ID = "//span[@class='field-validation-error']//span[@id='%s-error']";
	public static final String DYNAMIC_BUTTON = "//button[contains(text(),'%s')]";
	public static final String DYNAMIC_LINK = "//a[@class='%s']";
	
	public static final String ERROR_FORM_MESAGE_REGISTER = "//div[@class='message-error validation-summary-errors']";
	public static final String UPLOAD_FILE = "//input[@type='file']";
}
