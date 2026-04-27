package pageclasses;

import org.openqa.selenium.By;

import managers.ExtentTestManager;
import utils.UIActionUtils;

public class LoginPage {


	public static void click(By locator) {
        UIActionUtils.click(locator);
    }

    public static void sendKeys(By locator, String text) {
        UIActionUtils.sendKeys(locator, text);
        ExtentTestManager.log.info(" Entered " +text);

    }
    
    public static void sendKeysPassword(By locator, String text) {
        UIActionUtils.sendKeys(locator, text);
        ExtentTestManager.log.info(" Entered Password : ******");

    }

	
}
