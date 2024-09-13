@regress @smoke @saucedemo @login

  Feature: Login on Saudemo Swag Labs

    Scenario: Valid Login
      Given Given user access page saucedemo
      When user input username and password
      And user click on login button
      Then system display burger menu