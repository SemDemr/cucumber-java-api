Feature: Writing Scenarios with DataTable

  @DataTable
  Scenario: Add employee with DataTable
    When I login to the HRMS
    And I want to add employees
      | FirstName | MiddleName | LastName |
      | Kamer     | Can        | Akarsu   |
      | Sema      | Sem        | Demir    |
      | Tuba      | Sthg       | Kutlu    |
    Then I validate employee add
@menu
  Scenario: Dashboard Menu for Admin
    Given user is logged in with valid credentials
    Then I want to validate the items on the menu
      | Admin           |
      | PIM             |
      | My Info         |
      | Discipline      |
      | Reports Catalog |
      | More            |
      | Maintenance     |
