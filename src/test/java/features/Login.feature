@LoginFeature
Feature: Login Feature

  Background: Open the login page
    Given User has navigated to the login page

  @Regression @Sanity
  Scenario: Positive Login Scenario
    When User enters the correct username and password
    And User clicks on the logn button
    Then user should be navigated to the Home Page

  @Regression
  Scenario: Positive Login with Parameters
    When User enters the correct username "abc@xyz.com" and password "Abc@1234"
    And User clicks on the logn button
    Then user should be navigated to the Home Page

  Scenario Outline: Positive Login with Multiple Users
    When User enters the correct username "<Username>" and password "<Password>"
    And User clicks on the logn button
    Then user should be navigated to the Home Page

    Examples: 
      | Username    | Password  |
      | abc@xyz.com | Abc@12334 |

  Scenario Outline: Negative Login with Multiple Users
    When User enters the correct username "<Username>" and password "<Password>"
    And User clicks on the logn button
    Then user should be get error message "<Error>"

    Examples: 
      | Username     | Password | Error                                              |
      | pink@xyz.com | Def@1233 | The email or password you have entered is invalid. |

  @DataTable
  Scenario: Positive Login with Cucumber DataTable
    When User enters the correct credentials
      | Field    | Value       |
      | UserName | abc@xyz.com |
      | Password | AbcS@123    |
    And User clicks on the logn button
    Then user should be navigated to the Home Page
