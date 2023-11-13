Feature: Background Example

  Background: 
    Given Precondition1
    And Precondition2
@background
  Scenario: Example1
    When Test number nr1 firstname is "Sema" and lastname is "Demir"
    And Test number nr2
    And Test number nr3 age is 30
    Then Validation Nr1
    And Validation Nr2
@background
  Scenario: Example2
    When Test number nr4
    And Test number nr5
    And Test number nr6
    Then Validation Nr3
    And Validation Nr4
		
		
		#----------------
		#Hooks are executed for every feature file
		#Background is executed only for this feature file
		
		
		#----------------
		
		#Hooks --> @Before
    #Background steps
    #Scenario Example2
    #Hooks --> @After
		
		
		#----------------
		#Hooks --> @Before
    #Background steps
    #Scenario Example2
    #Hooks --> @After
