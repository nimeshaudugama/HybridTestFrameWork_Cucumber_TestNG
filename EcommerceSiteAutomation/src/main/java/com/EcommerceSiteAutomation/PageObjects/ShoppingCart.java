package com.EcommerceSiteAutomation.PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstarctComponents.AbstractComponents;

public class ShoppingCart extends AbstractComponents {

	WebDriver driver;

	public ShoppingCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".showcart")
	WebElement showcart;

	@FindBy(css = ".checkout")
	WebElement checkOutBtn;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public Shipping checkOut() {
		showcart.click();

		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		checkOutBtn.click();
		Shipping shipping = new Shipping(driver);
		return shipping;

	}
}
