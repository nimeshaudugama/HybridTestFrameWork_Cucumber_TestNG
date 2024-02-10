package AbstarctComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="ui-id-3")
	WebElement whatsNew;
	
	@FindBy(id="ui-id-4")
	WebElement women;
	
	
	

	
	public void goToWomen() {
		Actions actions = new Actions(driver);
		
		actions.moveToElement(women).perform();
		
		
	}
	
public void waitForElementToApper(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}

public void  waitForElementToPresent(By findby)	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.presenceOfElementLocated(findby));
	
}

public void  waitForElementToBeClickable(By findby)	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(findby));
	
}

//public void waitForPageToLoad(WebDriver driver) {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
//
//    wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
//}	

}
