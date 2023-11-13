Feature: Login Functionality

  @smoke @regression
  Scenario: Valid Login
    Given I navigated to the HRM website
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I validate that I am logged in
    And I will quit the browser

  @regression
  Scenario: Invalid Login
    Given I navigated to the HRM website
    When I enter a valid username
    And I enter an invalid password
    And I click on the login button
    Then I validate that
    And I will quit the browser

  @HW
  Scenario Outline: Login using Scenario Outline and Example Table
    When user enters login information "<username>" and "<password>"
    And I click on the login button
    Then verify that the "<employeeName>" is shown

    Examples: 
      | username | password   | employeeName  |
      | gurkan55 | gurkan@123 | Gurkan Tuncer |
      | murat    | murat@123  | Murat Murat   |
      | Xhimi    | imi78@36   | Lucky Lou     |

  @HW2
  Scenario: Login using DataTable
    When user enters username and password and clicks on the login button
      | username | password   | employeeName    |
      | gurkan55 | gurkan@123 | Gurkan Tuncer   |
      | murat    | murat@123  | Murat Murat     |
      | Serena   | Serena@123 | Serena Williams |
  
