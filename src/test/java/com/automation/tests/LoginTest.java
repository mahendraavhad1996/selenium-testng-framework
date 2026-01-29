package com.automation.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.utils.ExcelUtils;

public class LoginTest extends BaseTest{
	
	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return ExcelUtils.getTestData("Login");
	}
	
	@Test(dataProvider = "loginData")
	public void LoginTestForSite(String user, String pass) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.login(user, pass);
	}

}
