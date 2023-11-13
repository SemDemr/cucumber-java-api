package com.qa.steps;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableSteps {
	@When("I login to the HRMS")
	public void i_login_to_the_hrms() {
		System.out.println("login");
	}

	@When("I want to add employees")
	public void i_want_to_add_employees(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// List of maps??

		/*
		 * Map<String, String> map1 = new HashedMap<>();
		 * 
		 * map1.put(null, null); map1.put(null, null);
		 * 
		 * Map<String, String> map2 = new HashedMap<>(); map2.put(null, null);
		 * 
		 * Map<String, String> map3 = new HashedMap<>();
		 * 
		 * map3.put(null, null);
		 * 
		 * List<Map<String, String>> lm = new ArrayList<>(); lm.add(map1); lm.add(map2);
		 * lm.add(map3);*/
		 

		List<Map<String, String>> listOfMaps = dataTable.asMaps();
		for (Map<String, String> map : listOfMaps) {
			
			System.out.println("Firstname is :" + map.get("FirstName"));
			System.out.println("Middlename is :" + map.get("MiddleName"));
			System.out.println("Lastname is :" + map.get("LastName"));
			
		}

	}

	@Then("I validate employee add")
	public void i_validate_employee_add() {
		System.out.println("Validate employee added");
	}

}
