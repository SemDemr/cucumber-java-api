package com.neotech.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

@Given("I navigated to Google")

public void i_navigated_to_Google() {
	
	System.out.println("Opening google website");
}

@When("I type something on the search box")
public void i_type_sthng_onThe_SearchBox() {
	System.out.println("Typing something on the Search Box");
}
























}
