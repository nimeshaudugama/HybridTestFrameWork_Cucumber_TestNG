package com.EcommerceSiteAutomation.Tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.EcommerceSiteAutomation.PageObjects.ConfirmationPage;
import com.EcommerceSiteAutomation.PageObjects.LoginPage;
import com.EcommerceSiteAutomation.PageObjects.ReviewAndPayment;
import com.EcommerceSiteAutomation.PageObjects.SelectWomenJacket;
import com.EcommerceSiteAutomation.PageObjects.Shipping;
import com.EcommerceSiteAutomation.PageObjects.ShoppingCart;
import com.EcommerceSiteAutomation.TestComponents.BaseTest;

import com.EcommerceSiteAutomation.TestComponents.Retry;

/**
 * Unit test for simple App.
 */
public class PlaceTheOrder extends BaseTest
{
  
	

	
	@Test(dataProvider="getData"
	,retryAnalyzer=Retry.class)
    public void makeTheOrder(HashMap<String,String> input)
    {
		//landingpage.goTo();	
		LoginPage loginpage = landingpage.signIn();
    	SelectWomenJacket selectwomenjacket = loginpage.loginApplication(input.get("username"),input.get("password"));
    	selectwomenjacket.selectJacket();
    	selectwomenjacket.getProductName("Juno Jacket");
    	selectwomenjacket.addToCart();
        Shipping shipping = selectwomenjacket.checkOut();
        ReviewAndPayment reviewandpayment=shipping.selectShipping("Isuru", "Jayakody", "Queens Street","London","Alaska","N6G2N1","United States","+226345234");
        ConfirmationPage confirmationpage = reviewandpayment.placeOrder();
        confirmationpage.verifyConfirmation();
        
    	
    }
		
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//com//EcommerceSiteAutomation//data/AddToCart.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
		
	}
	
	
}
