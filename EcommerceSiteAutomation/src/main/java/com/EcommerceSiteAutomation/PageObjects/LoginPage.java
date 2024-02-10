package com.EcommerceSiteAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstarctComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='login[username]']")
	WebElement username;

	@FindBy(xpath = "//input[@name='login[password]']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit' and @class='action login primary']")
	WebElement submit;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement message;

	public SelectWomenJacket loginApplication(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		System.out.print("Clicked on Sumbmit button");
		SelectWomenJacket selectwomenjacket = new SelectWomenJacket(driver);
		return selectwomenjacket;

	}

	public String errorMessage() {

		return message.getText();
	}

}
