package com.EcommerceSiteAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstarctComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className = "authorization-link")
	WebElement authorizationLinkElement;

	public LoginPage signIn() {
		authorizationLinkElement.click();
		LoginPage loginpage = new LoginPage(driver);
		return loginpage;
	}

	public void goTo() {
		driver.get("https://magento.softwaretestingboard.com/");
	}

}
