
@OneBook
Feature: Get one book API
  This feature will get one book using the endpoint given in documentation

  Background:
   Given I create a get one book request
    And I provide the ISBN "9781449337711" as a query parameter
  
  
  
  
  Scenario: Get one book and validateed the response
    
    When I make a GEt call to Get One Book endpoint
    And I validate that the status code for getting a book is 200
    And I validate that the ISBN in the response body is "9781449337711"
    Then I validate that the book title is "Designing Evolvable Web APIs with ASP.NET"
   

  
