package stepDefinitions;



import utils.GenericUtils;
import utils.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;


public class OffersPageStepDefinition {
public String offersPageProductName;
TestContextSetup textContextSetup;
PageObjectManager pageObjectManager;


public OffersPageStepDefinition(TestContextSetup textContextSetup){
	this.textContextSetup = textContextSetup;
}




    @Then("^user searched for \"([^\"]*)\" shortname in offers page$")
    public void user_searched_for_something_shortname_in_offers_page(String shortName) throws Throwable {

    	switchToOffersPage();
    	Thread.sleep(2000);
    	OffersPage offersPage = new OffersPage(textContextSetup.testBase.driver);
    	offersPage.searchItem(shortName);
    	Thread.sleep(2000);
        offersPageProductName = offersPage.getProductName();
    }
    
    

	    
	public void switchToOffersPage(){
	    //Script for handle new windows
	    /*- Declara una variable que sea la ventanas
	      - Crea una varible tipo iterator con el metodo next(). Al ejecutarlo la primera vez para de null-->1 se 
	     incrementa cada vez que se llama
	     - Se declara una variable para la ventana principal y ventanas hijas.*/  
		//pageObjectManager = new PageObjectManager(textContextSetup.driver);
	//	pageObjectManager.getOffersPage();
		
		LandingPage landingPage = textContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDeals();
		textContextSetup.genericUtils.switchWindowToChild();
	};
    
    
    
    @And("^validate product name in offers page matches with Landing Page$")
    public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable {
    	
        Assert.assertEquals(offersPageProductName, textContextSetup.landingPageProductName);
    }

}