

Feature: Login Functionality
  
  Scenario: Valid Login
    Given I navigated to the HRM website
   
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in
    And I will quit the browser

  Scenario: Invalid Login
    Given I navigated to the HRM website
   
    When I enter a valid username
    And I enter an invalid password
    And I click on the login button
    Then I validate that 
    And I will quit the browser