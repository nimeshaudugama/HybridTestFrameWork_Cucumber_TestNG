package com.EcommerceSiteAutomation.PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstarctComponents.AbstractComponents;

public class Shipping extends AbstractComponents {

	WebDriver driver;

	public Shipping(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='input-text' and @name='firstname']")
	WebElement firstname;

	@FindBy(xpath = "//input[@class='input-text' and @name='lastname']")
	WebElement lastname;

	@FindBy(xpath = "//input[@class='input-text' and @name='street[0]']")
	WebElement address;

	@FindBy(xpath = "//input[@class='input-text' and @name='city']")
	WebElement city;

	@FindBy(xpath = "//input[@class='input-text' and @name='postcode']")
	WebElement postalCode;

	@FindBy(xpath = "//input[@class='input-text' and @name='telephone']")
	WebElement phoneNumber;

	@FindBy(css = "input.radio[value='tablerate_bestway']")
	WebElement radioButton2;

	@FindBy(css = ".continue")
	WebElement next;

	@FindBy(xpath = "//button[@class='action action-show-popup']")
	WebElement newAddress;

	public ReviewAndPayment selectShipping(String Fname, String Lname, String Address, String City, String State,
			String PostCode, String Country, String phone)

	{

		

	
		waitForElementToApper(By.xpath("//div[@class='opc-block-summary']"));

		if (firstname.isDisplayed()) {
	        
	       

			firstname.sendKeys(Fname);
			lastname.sendKeys(Lname);
			address.sendKeys(Address);
			city.sendKeys(City);

			waitForElementToPresent(By.xpath("//select[@name='region_id']"));
			WebElement state = driver.findElement(By.xpath("//select[@name='region_id']"));
			WebElement country = driver.findElement(By.xpath("//select[@name='country_id']"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			state.click();
			waitForElementToApper(By.xpath("//select[@name='region_id']"));

			Select dropdown = new Select(state);

			List<WebElement> options = dropdown.getOptions();

			for (WebElement option : options) {
				System.out.println(option.getText());
				if (option.getText().equals(State)) {

					option.click();

					// wait.until(ExpectedConditions.textToBePresentInElementValue(state,State));

					break;

				}
			}

			postalCode.sendKeys(PostCode);

			country.click();
			waitForElementToApper(By.cssSelector("select[data-bind*='attr'][name='country_id']"));

			Select dropdownCountry = new Select(country);

			List<WebElement> option = dropdownCountry.getOptions();

			for (WebElement opt : option) {
				if (opt.getText().equals(Country)) {

					opt.click();

				}

			}

			phoneNumber.sendKeys(phone);
			
			

			// Select the radio button
			if (!radioButton2.isSelected()) {
				waitForElementToBeClickable(By.cssSelector("input.radio[value='tablerate_bestway']"));
				radioButton2.click();
			}

			next.click();
			
		

	}
	
	

		else {

			if (!radioButton2.isSelected()) {
				radioButton2.click();
			}

			next.click();

		} 
		
		
		//(newAddress.isDisplayed()) 
		

	

	

	 ReviewAndPayment reviewandpayment = new ReviewAndPayment(driver);
	 return reviewandpayment;

}
}