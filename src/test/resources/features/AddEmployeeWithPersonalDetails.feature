#Author Neotech
Feature: Add Employee With Personal Details

  Background: 
    Given user is logged in with valid credentials
    And user navigates to Add employee page

  @HW4
  Scenario Outline: Add and Modify Employee Details
    When user enters employee "<firstName>" and "<lastName>"
    And user selects a location
    And user clicks save button
    Then I am able to modify Employee Details "<DriverLicense>", "<ExpirationDate>", "<Smoker>", "<Gender>", "<Nationality>"
    And I click on Personal Details Save

    Examples: 
      | firstName | lastName | DriverLicense | ExpirationDate | Smoker | Gender | Nationality |
      | Lionel    | Messi    | N78787886     | 2024-02-08     | No     | Male   | Argentinean |
      | Angelina  | Jolie    | T55578855     | 2023-05-10     | Yes    | Female | American    |
