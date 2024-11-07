package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.loginPage;
import commonFunctions.logoutPage;

public class AppUtils {
public static WebDriver driver;
public static Properties conpro;
@BeforeTest
public void setUp() throws Throwable
{
		conpro = new Properties();
		conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
		if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webDriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("url"));
			loginPage Login = PageFactory.initElements(driver, loginPage.class);
			Login.login("standard_user", "secret_sauce");
		}
		else if(conpro.getProperty("Browser").equalsIgnoreCase("Edge"))
		{
			System.setProperty("webDriver.Edge.driver","msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(conpro.getProperty("url"));
			loginPage Login = PageFactory.initElements(driver, loginPage.class);
			Login.login("standard_user", "secret_sauce");
		}
		else
		{
			Reporter.log("Browser value is not matching",true);
		}
		
}

@AfterTest
public void treaDown()
{
	logoutPage Logout = PageFactory.initElements(driver, logoutPage.class);
	Logout.logout();
	driver.quit();
}

}
