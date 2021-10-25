package com.cucumber.junit.pages;

import org.openqa.selenium.By;

import java.util.Map;


public class CheckoutShipment extends BasePage {

	private static final By ORDER_SUBTOTAL = By.cssSelector(".subtotal span");
	private static final By ORDER_TOTAL = By.cssSelector(".totals span");
	private static final By ORDER_TAX = By.cssSelector("div.tax > span");
	private static final By DISCOUNTS = By.cssSelector(".subtotals__item--state-discount > span");
	private static final By COUNTRY_REGION_DROPDOWN = By.xpath("//select[@id='address.country']");
	private static final By NEXT_BTN_ADDRESS = By.xpath("//button[@id='addressSubmit']");
	private static final By NEXT_BTN_SHIPMENT = By.xpath("//button[@id='deliveryMethodSubmit']");
	private static final By CARD_TYPE_DROPDOWN = By.xpath("//*[@id='card_cardType']");
	private static final By NAME_ON_CARD = By.xpath("//*[@id='card_nameOnCard']");
	private static final By CARD_NUMBER = By.xpath("//*[@id='card_accountNumber']");
	private static final By EXPIRY_YEAR_DROPDOWN = By.xpath("//*[@id='ExpiryYear']");
	private static final By EXPIRY_MONTH_DROPDOWN = By.xpath("//*[@id='ExpiryMonth']");
	private static final By CVV = By.xpath("//*[@id='card_cvNumber']");
	private static final By FIRST_NAME_ERROR_MESSAGE = By.xpath("//*[@id='firstName.errors']");
	private static final By LAST_NAME_ERROR_MESSAGE = By.xpath("//*[@id='lastName.errors']");
	private static final By ADDRESS_LINE1_ERROR_MESSAGE = By.xpath("//*[@id='line1.errors']");
	private static final By CITY_ERROR_MESSAGE = By.xpath("//*[@id='townCity.errors']");
	private static final By POST_CODE_ERROR_MESSAGE = By.xpath("//*[@id='postcode.errors']");
	private static final By FIRST_NAME = By.xpath("//*[@id='address.firstName']");
	private static final By LAST_NAME = By.xpath("//*[@id='address.surname']");
	private static final By ADDRESS_LINE1 = By.xpath("//*[@id='address.line1']");
	private static final By CITY = By.xpath("//*[@id='address.townCity']");
	private static final By POST_CODE = By.xpath("//*[@id='address.postcode']");

	private static final String ORDER_SUBTOTAL_TITLE = "Sub Total";
	private static final String DISCOUNTS_TITLE = "Discounts";
	private static final String ORDER_TAX_TITLE = "Tax";
	private static final String ORDER_TOTAL_TITLE = "Total";
	private static final String FIRST_NAME_TITLE = "First Name";
	private static final String LAST_NAME_TITLE = "Last Name";
	private static final String ADDRESS_LINE1_TITLE = "Address Line1";
	private static final String CITY_TITLE = "City";
	private static final String POST_CODE_TITLE = "Post Code";
	private static final String CARD_TYPE_TITLE = "Card Type";
	private static final String NAME_ON_CARD_TITLE = "Name on Card";
	private static final String CARD_NUMBER_TITLE = "Card Number";
	private static final String EXPIRY_YEAR_TITLE = "Expiry Year";
	private static final String EXPIRY_MONTH_TITLE = "Expiry Month";
	private static final String CVV_TITLE = "CVV";

	public String getOrderSubtotal() {
		return getElementText(ORDER_SUBTOTAL);
	}

	public String getOrderTotal() {
		return getElementText(ORDER_TOTAL);
	}

	public String getOrderTax() {
		return getElementText(ORDER_TAX);
	}

	public String getOrderDiscount() {
		return getElementText(DISCOUNTS);
	}

	public void getCountryRegionDropDown(String country) {
		setElementDoSelectByVisibleText(COUNTRY_REGION_DROPDOWN, country);
	}

	public void getNextButtonShipment() {
		clickElement(NEXT_BTN_SHIPMENT);
	}

	public void getCardTypeDropDown(String cardType) {
		setElementDoSelectByVisibleText(CARD_TYPE_DROPDOWN, cardType);
	}

	public void getNameOnCard(String nameOnCard) {
		setElementSendKeys(NAME_ON_CARD, nameOnCard);
	}

	public void getCardNumber(String cardNumber) {
		setElementSendKeys(CARD_NUMBER, cardNumber);
	}

	public void getExpiryYearDropDown(String expiryYear) {
		setElementDoSelectByVisibleText(EXPIRY_YEAR_DROPDOWN, expiryYear);
	}

	public void getExpiryMonthDropDown(String expiryMonth) {
		setElementDoSelectByVisibleText(EXPIRY_MONTH_DROPDOWN, expiryMonth);
	}

	public void getCvv(String cvv) {
		setElementSendKeysEnter(CVV, cvv);
	}

	public String getFirstNameErrorMessage() {
		return getElementText(FIRST_NAME_ERROR_MESSAGE);
	}

	public String getLastNameErrorMessage() {
		return getElementText(LAST_NAME_ERROR_MESSAGE);
	}

	public String getAddressLine1ErrorMessage() {
		return getElementText(ADDRESS_LINE1_ERROR_MESSAGE);
	}

	public String getCityErrorMessage() {
		return getElementText(CITY_ERROR_MESSAGE);
	}

	public String getPostCodeErrorMessage() {
		return getElementText(POST_CODE_ERROR_MESSAGE);
	}

	public void getFirstName(String firstName) {
		setElementSendKeys(FIRST_NAME, firstName);
	}

	public void getLastName(String lastName) {
		setElementSendKeys(LAST_NAME, lastName);
	}

	public void getAddressLine1(String addressLine1) {
		setElementSendKeys(ADDRESS_LINE1, addressLine1);
	}

	public void getCity(String city) {
		setElementSendKeys(CITY, city);
	}

	public void getPostCode(String postCode) {
		setElementSendKeys(POST_CODE, postCode);
	}

	public String getOrderSubtotalTitle() {
		return ORDER_SUBTOTAL_TITLE;
	}

	public String getOrderDiscountTitle() {
		return DISCOUNTS_TITLE;
	}

	public String getOrderTaxTitle() {
		return ORDER_TAX_TITLE;
	}

	public String getOrderTotalTitle() {
		return ORDER_TOTAL_TITLE;
	}

	public String getFirstNameTitle() {
		return FIRST_NAME_TITLE;
	}

	public String getLastNameTitle() {
		return LAST_NAME_TITLE;
	}

	public String getAddressLine1Title() {
		return ADDRESS_LINE1_TITLE;
	}

	public String getCityTitle() {
		return CITY_TITLE;
	}

	public String getPostCodeTitle() {
		return POST_CODE_TITLE;
	}

	public void getNextButtonAddress() {
		waitUntilElementClickable(NEXT_BTN_ADDRESS);
		jsScrollByPixels("0", "650");
		clickElement(NEXT_BTN_ADDRESS);
	}

	public void fillAddressInformation(Map<String, String> deliveryAddressInformation) {
		getFirstName(deliveryAddressInformation.get(FIRST_NAME_TITLE));
		getLastName(deliveryAddressInformation.get(LAST_NAME_TITLE));
		getAddressLine1(deliveryAddressInformation.get(ADDRESS_LINE1_TITLE));
		getCity(deliveryAddressInformation.get(CITY_TITLE));
		getPostCode(deliveryAddressInformation.get(POST_CODE_TITLE));
	}

	public void enterCardDetails(Map<String, String> addressInformation) {
		jsScrollByPixels("0", "500");
		getCardTypeDropDown(addressInformation.get(CARD_TYPE_TITLE));
		getNameOnCard(addressInformation.get(NAME_ON_CARD_TITLE));
		getCardNumber(addressInformation.get(CARD_NUMBER_TITLE));
		getExpiryYearDropDown(addressInformation.get(EXPIRY_YEAR_TITLE));
		getExpiryMonthDropDown(addressInformation.get(EXPIRY_MONTH_TITLE));
		getCvv(addressInformation.get(CVV_TITLE));
	}
}