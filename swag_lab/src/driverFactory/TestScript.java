package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.addcartFunction;
import config.AppUtils;

public class TestScript extends AppUtils{
@Test
public void startTest()
{
	addcartFunction AddCart = PageFactory.initElements(driver, addcartFunction.class);
	AddCart.addcart();
}

}
