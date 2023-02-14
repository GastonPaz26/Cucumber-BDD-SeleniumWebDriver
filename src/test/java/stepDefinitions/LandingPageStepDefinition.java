package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;




import org.openqa.selenium.chrome.ChromeDriver;


public class LandingPageStepDefinition {

TestContextSetup textContextSetup;

public LandingPageStepDefinition(TestContextSetup textContextSetup){
	this.textContextSetup = textContextSetup;
}



    @Given("^User is on GreenCart Landing page$")
    public void user_is_on_greencart_landing_page() throws Throwable {
    	
    
    }

    @When("^user searched with Shortname \"([^\"]*)\" and extracted actual name of product$")
    public void user_searched_with_shortname_something_and_extracted_actual_name_of_product(String shortName) throws Throwable{
    	LandingPage landingPage = textContextSetup.pageObjectManager.getLandingPage();
    	
    	landingPage.searchItem(shortName);
        Thread.sleep(5000);
        textContextSetup.landingPageProductName = landingPage.getProductName();
        
        textContextSetup.landingPageProductName = landingPage.extractProductName(textContextSetup.landingPageProductName);
        System.out.println(textContextSetup.landingPageProductName + " is extracted from Home Page");
       
    }
}
   