package com.qa.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

		// Which features to run //LoginToHRM.feature
		features = "@target/failed.txt",
		// code files
		glue = "com.qa.steps"

		)

public class FailedRunner {

}
