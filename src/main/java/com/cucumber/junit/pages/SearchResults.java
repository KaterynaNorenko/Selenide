package com.cucumber.junit.pages;

import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;


public class SearchResults extends BasePage {

	private static final String SEARCH_RESULTS_PAGE_URL = "https://ecsc00a08ec4:9002/yacceleratorstorefront/electronics/en/search/?text={searchText}";
	private static final By ADD_TO_ORDER_BTN = By.xpath("//form[@id='addToCartForm1934793']/descendant::button[@type='submit']");
	private static final By CHECKOUT_BTN = By.xpath("//a[@href='/yacceleratorstorefront/electronics/en/cart' and @class='btn btn-primary btn-block add-to-cart-button']");
	private static final By ADD_TO_CART_BTN = By.cssSelector("#addToCartForm1225694 > button");
	private static final By SEARCH_RESULTS_PRODUCTS = By.xpath("//*[@class='product__list--name']");
	private static final By RESULTS = By.xpath("//div[@class='results']");

	private static final String SHOP_BY_PRICE_PATTERN = "//span[contains(text(), '%s')]/preceding::span[@class='facet__list__mark'][1]";
	private static final String SHOP_BY_MEGAPIXELS_PATTERN = "//span[contains(text(), '%s')]/preceding::span[@class='facet__list__mark'][1]";
	private static final String SHOP_BY_BRAND_PATTERN = "//a[contains(@href, 'Abrand') and contains (text(), '%s')]";

	public void getAddToOrderButton() {
		waitUntilElementClickable(ADD_TO_ORDER_BTN);
		clickElement(ADD_TO_ORDER_BTN);
	}

	public void getCheckoutButton() {
		waitUntilElementClickable(CHECKOUT_BTN);
		clickElement(CHECKOUT_BTN);
	}

	public void getAddToCartButton() {
		waitUntilElementClickable(ADD_TO_CART_BTN);
		clickElement(ADD_TO_CART_BTN);
	}

	public String getSearchResultsPageUrl() {
		return SEARCH_RESULTS_PAGE_URL;
	}

	public String getSearchResultsPageUrlWithParams(String searchText) {
		return SEARCH_RESULTS_PAGE_URL.replace("{searchText}", searchText.replace(" ", "+"));
	}

	public List<String> getSearchResultsByXpath() {
		waitUntilElementVisible(SEARCH_RESULTS_PRODUCTS);
		return getResults(SEARCH_RESULTS_PRODUCTS);
	}

	public void applySearchFilters(Map<String, String> filterValues) {
		findElementByDynamicXpathAndClick(SHOP_BY_PRICE_PATTERN, filterValues.get("Price"));
		waitUntilElementVisible(RESULTS);
		findElementByDynamicXpathAndClick(SHOP_BY_MEGAPIXELS_PATTERN, filterValues.get("Megapixels"));
		waitUntilElementVisible(RESULTS);
		findElementByDynamicXpathAndClick(SHOP_BY_BRAND_PATTERN, filterValues.get("Brand"));
	}
}