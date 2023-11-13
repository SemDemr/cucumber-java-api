@homework
Feature: Add Employee

  Background: 
    Given user is logged in with valid credentials
    And user navigates to Add employee page
    #Scenario: Add Employee with first and last name
    Then user enters employee first name and last name
    And selects the location
    And get employee ID
    And user clicks save button
    Then I validate the employee with ID
    #Scenario: Add Employee without employee id
    Then user enters employee first name and last name
    And selects the location
    And delete employee id
    Then user clicks save button
    Then I validate the employee

  @homework3
  Scenario: Add Employee and create login credentials
    Then user enters employee first name and last name
    And selects the location
    Then switch login details button
    And enters username and password and confirms password
    And get employee ID
    And user clicks save button

  #Then I validate the employee with ID
  @Task3
  Scenario Outline: Add employee with parameters
    Given user is logged in with valid credentials
    And user navigates to Add employee page
    Then user enters employee "<firstName>" and "<lastName>"

    Examples: 
      | firstName | lastName |
      | sema      | demir    |

  #To perform DDT using Scenario Outline and Examples keyword
  @scenarioOutline
  Scenario Outline: Adding multiple employees with scenario outline
    When user enters employee "<FirstName>", "<MiddleName>" and "<LastName>"
    And user selects a location "<Location>"
    And user clicks save button
    Then validate that "<FirstName>" and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName | Location                         |
      | Joe       | R          | Biden    | London Office                    |
      | Donald    | J          | Trump    | Chinese Development Center       |
      | Barack    | H          | Obama    | South African Development Center |

  @excelDataTable
  Scenario: Add multiple employees from Excel
    When user enters employee data from "Employee" excel sheet then save
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
