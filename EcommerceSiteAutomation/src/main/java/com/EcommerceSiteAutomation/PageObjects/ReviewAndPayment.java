package com.EcommerceSiteAutomation.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstarctComponents.AbstractComponents;

public class ReviewAndPayment extends AbstractComponents {

	WebDriver driver;

	public ReviewAndPayment(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@class='action primary checkout']")
	WebElement placeOrder;

	public ConfirmationPage placeOrder() {
		
		waitForElementToApper(By.xpath("//button[@class='action primary checkout']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrder);

		//waitForElementToBeClickable(By.xpath("//button[@class='action primary checkout']"));

		placeOrder.click();
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		return confirmationpage;
	}

}
