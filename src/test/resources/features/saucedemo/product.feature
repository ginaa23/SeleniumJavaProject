@regress @smoke @saucedemo @login

Feature: Login on Saudemo Swag Labs

  Background: user success login to system
    Given Given user access page saucedemo
    When user input username "visual_user" and password "secret_sauce"
    And user click on login button

  @Verify-ButtonRemove
  Scenario: Verify system display button remove after add selected product to cart
    When user click on Add to cart
    And button changed to Remove

  @Verify-CartItemCountIncrease
  Scenario: Verify system increases the number of items added each time a user adds a product
    When user add 2 product
    Then the cart item display 2

  @Verify-CartItemCountDecrease
  Scenario: Verify system reduces the number of items added each time a user deletes a product
    When user add 2 product
    And user remove 1 product from cart
    Then the cart item display 1

  @SortProduct-NameAscending
  Scenario: Sort product base on product name - ascending
    When user sort product "Z" to "A"
    Then system display product

  @SortProduct-NameDescending
  Scenario: Sort product base on product name - descending
    When user sort product "Z" to "A"
    Then system display product
