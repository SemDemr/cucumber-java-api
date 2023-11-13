@task1
Feature: Search for Employee

  Scenario: Search employee by Id
    Given user is logged in with valid credentials
    And user navigates to the employee list page
    When user enters valid employee id
    And clicks on search button
    Then employee information is displayed

  Scenario: Search employee by first and last name
    Given user is logged in with valid credentials
    And user navigates to the employee list page
    When user enters valid employee first and last name
    And clicks on search button
    Then employee information is displayed
