Feature: As a user I want to get ability to create order

  @regression
  Scenario: Proceed to checkout, final review and place order as guest user
    Given I open the Initial Home Page
    When I search for "DSC WX"
    And I am redirected to a "search" results page
    And Search results contain the following products
      | LI-ION F SERIES G |
      | DCS-WX1           |
      | DCS-N1            |
    And I apply the following search filters
      | Price      | $500-$999 |
      | Megapixels | 10 - 10.9 |
      | Brand      | Canon     |
    And Search results contain only the following products
      | EOS 40D BODY |
    And I click Add to cart button for product with name EOS 40D BODY
    And I select Checkout in cart pop-up
    And I am redirected to a "cart" page
    And Cart order summary is as following:
      | Tax                                 | Total   |
      | *No taxes are included in the total | $787.37 |
    And I click Checkout button on Cart page
    And I checkout as a new customer with email "test@user.com"
    And I perform email confirmation "test@user.com"
    And Checkout order summary is as following:
      | Sub Total | Discounts | Tax    | Total   |
      | $787.37   | - $20.00  | $39.37 | $826.74 |
    And I select the COUNTRY&REGION "Ukraine" manually
    And I click the next button
    And the following validation messages are displayed for shipping address
      | First Name    | Please enter a first name   |
      | Last Name     | Please enter a last name    |
      | Address Line1 | Please enter address Line 1 |
      | City          | Please enter a Town/City    |
      | Post Code     | Please enter post code      |
    And I fill delivery address information manually:
      | First Name | Last Name | Address Line1    | City | Post Code |
      | First      | Last      | Random address 1 | Kyiv | 123456    |
    When I press Next button on checkout
    And I confirm Shipment Method by pressing another Next button
    And I enter my card details
      | Card Type    | Visa             |
      | Name on Card | Random Name      |
      | Card Number  | 4111111111111111 |
      | Expiry Year  | 2022             |
      | Expiry Month | 03               |
      | CVV          | 123              |