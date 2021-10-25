package com.cucumber.junit.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.assertj.core.api.SoftAssertions;

import com.cucumber.junit.pages.*;

import io.cucumber.java.*;
import io.cucumber.java.en.*;


public class DesktopCheckoutForGuestUserSteps {
	private final HomePage homePage = new HomePage();
	private final SearchResults searchResults = new SearchResults();
	private final CartPage cartPage = new CartPage();
	private final SignInRegister signInRegister = new SignInRegister();
	private final CheckoutShipment checkoutShipment = new CheckoutShipment();

	@Given("I open the Initial Home Page")
	public void openHomePage() {
		homePage.openAcceleratorWebsite();
	}

	@When("I search for {string}")
	public void searchForItem(String productNumber) {
		homePage.getSearchInput(productNumber);
	}

	@Then("I am redirected to a {string} results page")
	public void redirectToSearchResults(String page) {
		assertThat(searchResults.getSearchResultsPageUrl())
				.as("Redirect to Search Page was unsuccessful")
				.containsIgnoringCase(page);
	}

	@Then("Search results contain the following products")
	public void searchResultsContainProducts(List<String> expectedProducts) {
		assertThat(searchResults.getSearchResultsByXpath())
				.as("Results do not contain expected products")
				.containsAnyElementsOf(expectedProducts);
	}

	@When("I apply the following search filters")
	public void applySearchFilters(Map<String, String> filterValues) {
		searchResults.applySearchFilters(filterValues);
	}

	@Then("Search results contain only the following products")
	public void searchResultsContainOnlyTheFollowingProducts(List<String> expectedProducts) {
		assertThat(searchResults.getSearchResultsByXpath())
				.as("Results do not contain expected products")
				.isEqualTo(expectedProducts);
	}

	@When("I click Add to cart button for product with name EOS 40D BODY")
	public void clickAddToCartButtonForProductWithName() {
		searchResults.getAddToCartButton();
	}

	@When("I select Checkout in cart pop-up")
	public void selectCheckoutInCartPopUp() {
		searchResults.getCheckoutButton();
	}

	@Then("I am redirected to a {string} page")
	public void redirectToCartPage(String page) {
		assertThat(cartPage.getCartPageUrl())
				.as("Redirect to Cart Page was unsuccessful")
				.containsIgnoringCase(page);
	}

	@Then("Cart order summary is as following:")
	public void cartOrderSummaryIsFollowing(@Transpose Map<String, String> expectedValuesInCartOrderSummary) {
		SoftAssertions softly = new SoftAssertions();

		softly.assertThat(cartPage.getCartOrderTax())
				.as("Cart Tax is not as expected")
				.isEqualToIgnoringCase(expectedValuesInCartOrderSummary.get(cartPage.getCartOrderTaxTitle()));

		softly.assertThat(cartPage.getCartOrderTotal())
				.as("Cart Total is not as expected")
				.isEqualToIgnoringCase(expectedValuesInCartOrderSummary.get(cartPage.getCartOrderTotalTitle()));

		softly.assertAll();
	}

	@When("I click Checkout button on Cart page")
	public void clickCheckoutButtonOnCartPage() {
		cartPage.getCheckoutButton();
	}

	@When("I checkout as a new customer with email {string}")
	public void checkoutAsANewCustomerWithEmail(String email) {
		signInRegister.inputEmail(email);
	}

	@When("I perform email confirmation {string}")
	public void performEmailConfirmation(String email) {
		signInRegister.inputEmailConfirmation(email);
	}

	@Then("Checkout order summary is as following:")
	public void checkoutOrderSummaryIsAsFollowing(@Transpose Map<String, String> expectedValuesInOrderSummary) {
		SoftAssertions softly = new SoftAssertions();

		softly.assertThat(checkoutShipment.getOrderSubtotal())
				.as("Order Subtotal is not as expected")
				.isEqualToIgnoringCase(expectedValuesInOrderSummary.get(checkoutShipment.getOrderSubtotalTitle()));

		softly.assertThat(checkoutShipment.getOrderDiscount())
				.as("Order Discount is not as expected")
				.isEqualToIgnoringCase(expectedValuesInOrderSummary.get(checkoutShipment.getOrderDiscountTitle()));

		softly.assertThat(checkoutShipment.getOrderTax())
				.as("Order Tax is not as expected")
				.isEqualToIgnoringCase(expectedValuesInOrderSummary.get(checkoutShipment.getOrderTaxTitle()));

		softly.assertThat(checkoutShipment.getOrderTotal())
				.as("Order Total is not as expected")
				.isEqualToIgnoringCase(expectedValuesInOrderSummary.get(checkoutShipment.getOrderTotalTitle()));

		softly.assertAll();
	}

	@When("I select the COUNTRY&REGION {string} manually")
	public void selectCountryRegionManually(String country) {
		checkoutShipment.getCountryRegionDropDown(country);
	}

	@When("I click the next button")
	public void clickTheNextButton() {
		checkoutShipment.getNextButtonAddress();
	}

	@Then("the following validation messages are displayed for shipping address")
	public void verifyValidationMessagesAreDisplayedForShippingAddress(Map<String, String> expectedValidationMessages) {
		SoftAssertions softly = new SoftAssertions();

		softly.assertThat(checkoutShipment.getFirstNameErrorMessage())
				.as("First Name error message is not as expected")
				.isEqualToIgnoringCase(expectedValidationMessages.get(checkoutShipment.getFirstNameTitle()));

		softly.assertThat(checkoutShipment.getLastNameErrorMessage())
				.as("Last Name error message is not as expected")
				.isEqualToIgnoringCase(expectedValidationMessages.get(checkoutShipment.getLastNameTitle()));

		softly.assertThat(checkoutShipment.getAddressLine1ErrorMessage())
				.as("Address Line error message is not as expected")
				.isEqualToIgnoringCase(expectedValidationMessages.get(checkoutShipment.getAddressLine1Title()));

		softly.assertThat(checkoutShipment.getCityErrorMessage())
				.as("City error message is not as expected")
				.isEqualToIgnoringCase(expectedValidationMessages.get(checkoutShipment.getCityTitle()));

		softly.assertThat(checkoutShipment.getPostCodeErrorMessage())
				.as("Post Code error message is not as expected")
				.isEqualToIgnoringCase(expectedValidationMessages.get(checkoutShipment.getPostCodeTitle()));
	}

	@When("I fill delivery address information manually:")
	public void fillDeliveryAddressInformationManually(@Transpose Map<String, String> deliveryAddressInformation) {
		checkoutShipment.fillAddressInformation(deliveryAddressInformation);
	}

	@When("I press Next button on checkout")
	public void pressNextButtonOnCheckout() {
		checkoutShipment.getNextButtonAddress();
	}

	@When("I confirm Shipment Method by pressing another Next button")
	public void confirmShipmentMethodByPressingAnotherNextButton() {
		checkoutShipment.getNextButtonShipment();
	}

	@When("I enter my card details")
	public void enterMyCardDetails(Map<String, String> cardDetails) {
		checkoutShipment.enterCardDetails(cardDetails);
	}
}