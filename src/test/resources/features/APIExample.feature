@API
Feature: Add Book to Account API

  Background: 
    Given a token is generated

  Scenario: Adding a book and validating the account
    When I add a book to the account
    And I get the account information
    Then I validate that the book is in the account
