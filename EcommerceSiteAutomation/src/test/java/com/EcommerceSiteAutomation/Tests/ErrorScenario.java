package com.EcommerceSiteAutomation.Tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.EcommerceSiteAutomation.PageObjects.LoginPage;
import com.EcommerceSiteAutomation.TestComponents.BaseTest;

public class ErrorScenario extends BaseTest{
	
	
	@Test

	public void errorLogin() {
		
		LoginPage loginpage = landingpage.signIn();
		loginpage.loginApplication("isurujayakody123@gmail.com", "test123");
		Assert.assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.",loginpage.errorMessage());
		
	}

}
