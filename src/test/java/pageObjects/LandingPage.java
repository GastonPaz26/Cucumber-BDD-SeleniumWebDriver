package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	private WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		this.driver= driver;
	};
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4[class=\"product-name\"]");
	By topDeals = By.linkText("Top Deals");
	

	public void searchItem(String shortName) 
	{
		driver.findElement(search).sendKeys(shortName);
	};
	
	public void getSearchText() 
	{
		driver.findElement(search).sendKeys();
	};
	
	
	public void selectTopDeals() 
	{
		driver.findElement(topDeals).click();
	}; 
	
	public String getProductName() 
	{
		return driver.findElement(productName).getText();
	};
	
	public String extractProductName(String fullProductName) 
	{
		return fullProductName.split("-")[0].trim();

	};
	
}

