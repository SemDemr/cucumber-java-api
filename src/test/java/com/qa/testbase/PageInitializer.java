package com.qa.testbase;

import com.qa.pages.AddEmployeePageElements;
import com.qa.pages.DashboardPageElements;
import com.qa.pages.EmployeeListPageElements;
import com.qa.pages.LoginPageElements;
import com.qa.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass{

	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static AddEmployeePageElements addEmployee;
	public static PersonalDetailsPageElements personalDetails;
	public static EmployeeListPageElements employeeList;

public static void initialize() {
	
	login = new LoginPageElements();
	dashboard = new DashboardPageElements();
	
	addEmployee = new AddEmployeePageElements();
	personalDetails = new PersonalDetailsPageElements();
	
	employeeList = new EmployeeListPageElements();
	
	
	
	
	
}











}
