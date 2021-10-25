Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  @smoke
  Scenario: Order should contain appropriate totals
    Given the user opens Accelerator website
    When the user searches for a product with number "1934793"
    And the user adds item to order
    And the user clicks on checkout button
    And the user clicks on checkout button on cart page
    And the user inputs email "test@user.com"
    And the user performs email confirmation "test@user.com"
    Then order subtotal is displayed and equals "$95.10"
    And order total is displayed and equals "$99.86"
    And order tax is displayed and equals "$4.76"