package com.qa.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

		// Which features to run //LoginToHRM.feature
		features = "src/test/resources/features/",
		// code files
		glue = "com.qa.steps",

		dryRun = false,

		// group name "@smoke or/and @regression"
		tags = "@regression",

		monochrome = true,

		plugin = { "pretty", "html:target/cucumber-default-report.html", "json:target/cucumber.json",

				"rerun:target/failed.txt"

		})

public class RegressionRunner {

}
