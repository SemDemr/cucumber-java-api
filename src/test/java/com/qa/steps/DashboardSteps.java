package com.qa.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.qa.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class DashboardSteps extends CommonMethods {

	@When("I want to validate the items on the menu")
	public void validateMenu(DataTable dataTable) {

		List<String> expectedList = dataTable.asList();

		List<String> actualList = new ArrayList<>();

		click(dashboard.moreMenuItem);

		wait(2);
		for (WebElement el : dashboard.menuList) {
			actualList.add(el.getText());

		}

		Assert.assertEquals(expectedList, actualList);

	}
}
