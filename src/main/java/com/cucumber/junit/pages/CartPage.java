package com.cucumber.junit.pages;

import org.openqa.selenium.By;


public class CartPage extends BasePage {

	private static final String CART_PAGE_URL = "https://ecsc00a08ec4:9002/yacceleratorstorefront/electronics/en/cart";
	private static final By CHECKOUT_BTN_CART = By.xpath("//div[@class='cart__actions border']/descendant::button[@class='btn btn-primary btn-block btn--continue-checkout js-continue-checkout-button']");
	private static final By CART_ORDER_TAX = By.xpath("//div[@class='cart-totals-taxes text-right']");
	private static final By CART_ORDER_TOTAL = By.xpath("//div[@class='col-xs-6 cart-totals-right text-right grand-total']");

	private static final String CART_ORDER_TAX_TITLE = "Tax";
	private static final String CART_ORDER_TOTAL_TITLE = "Total";

	public void getCheckoutButton() {
		clickElement(CHECKOUT_BTN_CART);
	}

	public String getCartOrderTax() {
		return getElementText(CART_ORDER_TAX);
	}

	public String getCartOrderTotal() {
		return getElementText(CART_ORDER_TOTAL);
	}

	public String getCartPageUrl() {
		return CART_PAGE_URL;
	}

	public String getCartOrderTaxTitle() {
		return CART_ORDER_TAX_TITLE;
	}

	public String getCartOrderTotalTitle() {
		return CART_ORDER_TOTAL_TITLE;
	}
}