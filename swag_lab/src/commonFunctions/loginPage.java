package commonFunctions;


import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class loginPage {
	
	@FindBy(xpath = "//input[@name='user-name']")
	WebElement objUserName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement objPassword;
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement objLoginButton;
	
	public void login(String username, String password) throws Throwable
	{
		Thread.sleep(Duration.ofSeconds(3000));
		objUserName.sendKeys(username);
		objPassword.sendKeys(password);
		objLoginButton.click();
	}

}
