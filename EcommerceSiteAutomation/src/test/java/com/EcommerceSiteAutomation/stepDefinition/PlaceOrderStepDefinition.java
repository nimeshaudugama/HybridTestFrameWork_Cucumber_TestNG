package com.EcommerceSiteAutomation.stepDefinition;

import java.io.IOException;

import com.EcommerceSiteAutomation.PageObjects.ConfirmationPage;
import com.EcommerceSiteAutomation.PageObjects.LandingPage;
import com.EcommerceSiteAutomation.PageObjects.LoginPage;
import com.EcommerceSiteAutomation.PageObjects.ReviewAndPayment;
import com.EcommerceSiteAutomation.PageObjects.SelectWomenJacket;
import com.EcommerceSiteAutomation.PageObjects.Shipping;
import com.EcommerceSiteAutomation.TestComponents.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrderStepDefinition extends BaseTest{
	
	public LandingPage landingpage;
	public SelectWomenJacket selectwomenjacket;
	public 	Shipping shipping;
	public    ReviewAndPayment reviewandpayment;
	public  ConfirmationPage confirmationpage;
	
	
	@Given("I am on the landing page")
	public void i_am_on_landing_page() throws IOException {
		
		landingpage = launchSite();
		
		
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password (String username,String password)
	{
		 
		LoginPage loginpage = landingpage.signIn();
		selectwomenjacket = loginpage.loginApplication(username,password);
	}
	
	@When("I select the jacket")
	public void i_select_the_jacket() {
		
		selectwomenjacket.selectJacket();
    	selectwomenjacket.getProductName("Juno Jacket");
		
	}
	
	@And("I click on Add to cart")
	public void i_click_on_Add_to_cart() {
		selectwomenjacket.addToCart();
		shipping = selectwomenjacket.checkOut();
	}
	
	@And("^I add the shipping address (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+)$")
	public void i_add_the_shipping_address(String Fname, String Lname, String Address, String City, String State,
			String PostCode, String Country, String phone) {
		
        reviewandpayment=shipping.selectShipping(Fname,Lname,Address,City,State,PostCode,Country,phone);
		
	}
	
	@Then("I verify the payment")
	public void then_I_verify_the_payment() {
	   confirmationpage = reviewandpayment.placeOrder();
		}
	
	
	@And("Check for confirmation message")
	public void check_for_confirmation_message() {
		
		 confirmationpage.verifyConfirmation();
		
	}
	
	
	@After
	public void tear_down()
	{
		tearDown();
	}	
	
}