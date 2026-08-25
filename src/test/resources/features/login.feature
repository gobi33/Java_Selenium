Feature: Login Functionality

  @Smoke
  Scenario: Valid Login and Purchase

    Given User is on login page
    When User enters valid username and password
    And User clicks login button
    Then User should login successfully

    When the user is on the Home Page
    And the user searches for "laptop"
    And the user adds the product to the cart
    And the user proceeds to checkout
    Then the order should be placed successfully

@Regression
Scenario: InValid Login

Given User is on login page
When User enters invalid username and password
And User clicks login button
Then User returns login error message
@Smoke
Scenario Outline: Valid Login

Given User is on login page
When User enters "<email>" and "<password>"
And User clicks login button
Then User display the result

Examples:
    | email                     | password     |
    | DemoWebsite@gmail.com     | Website@123  | 
    | DemoWebsite0@gmail.com    | Website@1234 |

Scenario Outline: Registration 

Given User is on register page
When User enters valid details "<firstname>" , "<lastname>" and "<pass>", "<confpass>"
And User clicks the register button
Then User returns the result

Examples:
    | firstname | lastname | pass         | confpass     |
    | Demo      | Website  | Website@001  | Website@001  |
    | Demo      | Website  | Website@001  | Website@01   |

