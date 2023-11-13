Feature: Writing Scenario Outline Example

  @Outline
  Scenario Outline: 
    When Login with "<username>" and "<password>"
    And Click on the login button
    Then I validate Welcome "<username>" is displayed
    And We want to say Bye "<fullname>" 

    Examples: 
      | username | password |fullname|
      | sema     | s1234    |semademir|
      | emre     | emre123  |emreyucel|
      | mehpare  | meh123   |mehparebal|
