@regress @smoke @saucedemo @login

  Feature: Login on Saudemo Swag Labs

    @Login-ValidLogin
    Scenario: Valid Login
      Given Given user access page saucedemo
      When user input username "visual_user" and password "secret_sauce"
      And user click on login button
      Then system display burger menu

    @Login-LockedAccount
    Scenario: Login with locked account
      Given Given user access page saucedemo
      When user input username "locked_out_user" and password "secret_sauce"
      And user click on login button
      Then system display error message "Epic sadface: Sorry, this user has been locked out."

    @Login_InvalidAccount
    Scenario: Login with invalid account
      Given Given user access page saucedemo
      When user input username "invalid_user" and password "secret_sauce"
      And user click on login button
      Then system display error message "Epic sadface: Username and password do not match any user in this service"

    @Login_SuccessLogout
    Scenario: Login with valid account and success logout
      Given Given user access page saucedemo
      When user input username "standard_user" and password "secret_sauce"
      And user click on login button
      And user click burger menu
      Then user click logout sidebar