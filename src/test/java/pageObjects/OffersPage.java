package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	public WebDriver driver;

	public OffersPage(WebDriver driver)
	{
		this.driver= driver;
	};
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("tr td:nth-child(1)");

	

	public void searchItem(String shortName) 
	{
		driver.findElement(search).sendKeys(shortName);
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

