package com.cucumber.junit.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.cucumber.junit.pages.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateOrderSteps {
	private final HomePage homePage = new HomePage();
	private final SearchResults searchResults = new SearchResults();
	private final CartPage cartPage = new CartPage();
	private final SignInRegister signInRegister = new SignInRegister();
	private final CheckoutShipment checkoutShipment = new CheckoutShipment();

	@Given("the user opens Accelerator website")
	public void openAcceleratorWebsite() {
		homePage.openAcceleratorWebsite();
	}

	@When("the user searches for a product with number {string}")
	public void searchForItem(String productNumber) {
		homePage.getSearchInput(productNumber);
	}

	@When("the user adds item to order")
	public void addItemToOrder() {
		searchResults.getAddToOrderButton();
	}

	@When("the user clicks on checkout button")
	public void clickOnCheckoutButton() {
		searchResults.getCheckoutButton();
	}

	@When("the user clicks on checkout button on cart page")
	public void clickOnCheckoutButtonCartPage() {
		cartPage.getCheckoutButton();
	}

	@When("the user inputs email {string}")
	public void inputEmail(String email) {
		signInRegister.inputEmail(email);
	}

	@When("the user performs email confirmation {string}")
	public void performEmailConfirmation(String email) {
		signInRegister.inputEmailConfirmation(email);
	}

	@Then("order subtotal is displayed and equals {string}")
	public void verifyOrderSubtotalPresence(String expectedSubtotal) {
		assertThat(checkoutShipment.getOrderSubtotal())
				.as("Order Subtotal is not as expected")
				.isEqualToIgnoringCase(expectedSubtotal);
	}

	@Then("order total is displayed and equals {string}")
	public void verifyOrderTotalPresence(String expectedTotal) {
		assertThat(checkoutShipment.getOrderTotal())
				.as("Order Total is not as expected")
				.isEqualToIgnoringCase(expectedTotal);
	}

	@Then("order tax is displayed and equals {string}")
	public void verifyOrderTaxPresence(String expectedTax) {
		assertThat(checkoutShipment.getOrderTax())
				.as("Order Tax is not as expected")
				.isEqualToIgnoringCase(expectedTax);
	}
}