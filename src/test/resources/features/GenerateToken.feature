
@Token
Feature: Generate Token API
  
  Background:
  Given I create generate token request
    And I provide the header for generate token request
    And I provide the body for generate token request
  
  Scenario:
   When I make a Post call to generate token endpoint
    Then I validate the status code for generate token request is 200
    And I validate that the body contains "Success"
    And I validate that the value of the "result" is "User authorized successfully."

  