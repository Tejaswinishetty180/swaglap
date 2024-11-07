package commonFunctions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

public class addcartFunction {
	private static final Duration Duration = null;

	WebDriver driver;
	
	public addcartFunction(WebDriver driver)
	{
		this.driver = driver;
	}

	@FindBy(xpath = "//span[@class='title']")
	WebElement objProductPage;
	
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
	WebElement objItemName;
	
	@FindBy(xpath = "//div[normalize-space()='$29.99']")
	WebElement objItemPrice;
	
	@FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
	WebElement objAddcart; 
	
	@FindBy(xpath = "//a[contains(.,'1')]")
	WebElement objAddcartIcon;
	
	public void addcart()
	{
		String exp = this.objProductPage.getText();
		String act = "inventory";
		if(exp.contains(act))
		{
			Reporter.log("It is product page");
		}
		
		String FirstItemName= this.objItemName.getText();
		String FirstItemPrice = this.objItemPrice.getText();
		this.objAddcart.click();
		
		this.objAddcartIcon.click();
		
		String VerifItemName = this.objItemName.getText();
		String VerifItemPrice = this.objItemPrice.getText();
		assertEquals(FirstItemName,VerifItemName);
	    assertEquals(FirstItemPrice,VerifItemPrice);
		
	}
}
