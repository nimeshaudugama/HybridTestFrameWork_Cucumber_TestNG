package com.EcommerceSiteAutomation.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstarctComponents.AbstractComponents;

public class SelectWomenJacket extends AbstractComponents {

	WebDriver driver;

	public SelectWomenJacket(WebDriver driver) {
		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ui-id-4")
	WebElement women;

	@FindBy(id = "ui-id-9")
	WebElement top;

	@FindBy(id = "ui-id-11")
	WebElement jacket;

	@FindBy(xpath = "//div[@class='product details product-item-details']")
	List<WebElement> Jackets;

	By size = By.id("option-label-size-143-item-166");

	@FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement message;

	@FindBy(xpath = "//a[text()='shopping cart']")
	WebElement messageContent;

	@FindBy(css = ".showcart")
	WebElement showcart;

	public void selectJacket() {
		Actions actions = new Actions(driver);
		actions.moveToElement(women).perform();
		actions.moveToElement(top).perform();
		actions.moveToElement(jacket).perform();
		jacket.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement desiredElement = driver.findElement(By.xpath("(//li[@class='item product product-item'])[1]"));
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", desiredElement);

	}

	public WebElement getProductName(String topName) {

		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		WebElement top = Jackets.stream()
				.filter(product -> product.findElement(By.cssSelector("a")).getText().equals(topName)).findFirst()
				.orElse(null);
		System.out.print("Clicked on the jacket");
		top.click();
		return top;
	}

	public void addToCart() {
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		List<WebElement> elements = driver.findElements(By.id("option-label-size-143-item-166"));
		if (elements.size() >= 2) {
			elements.get(1).click();
		}

		List<WebElement> colors = driver.findElements(By.id("option-label-color-93-item-53"));
		if (colors.size() >= 2) {
			colors.get(0).click();
		}

		// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tocart")));
		waitForElementToPresent(By.cssSelector(".tocart"));

		List<WebElement> addToCart = driver.findElements(By.cssSelector(".tocart"));
		if (addToCart.size() >= 2) {
			addToCart.get(1).click();

		}

		Actions actions = new Actions(driver);
		actions.moveToElement(messageContent);
		// messageContent.click();

		message.getText();

	}

	public Shipping checkOut() {

		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		showcart.click();

		waitForElementToApper(By.cssSelector(".ui-dialog"));

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-dialog")));

		WebElement dialogBox = driver.findElement(By.cssSelector(".ui-dialog"));

		WebElement checkOutBtn = dialogBox.findElement(By.id("top-cart-btn-checkout"));
		checkOutBtn.click();
		Shipping shipping = new Shipping(driver);
		return shipping;

	}

}
