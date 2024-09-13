@regress @login @hdi @checkout

Feature: Login HDI

  Scenario: Negative case login hdi
    Given user access page hdi
    When users click on hdi login button on header menu
    And users input hdi email "ID55666777"
    And users input  hdi password "XXyyZZZ"
    And users click on hdi login button
    Then system display hdi login alert box is "Your Enterpriser ID or Password is incorrect (2)."