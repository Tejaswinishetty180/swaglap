package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class logoutPage {
	@FindBy(xpath = " ")
	WebElement objLogoutButton;
	
	public void logout() 
	{
		objLogoutButton.click();
	}
	

}
