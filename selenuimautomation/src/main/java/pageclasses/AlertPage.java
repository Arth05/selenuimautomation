package pageclasses;

import org.openqa.selenium.By;

import managers.AlertManager;
import managers.ExtentTestManager;
import utils.UIActionUtils;

public class AlertPage {
	
	public static void basicAlert(By locator) {	
		UIActionUtils.click(locator);
		ExtentTestManager.log.info("Clicked on the Button");
		AlertManager.acceptAlert();
		ExtentTestManager.log.info("Accepted the Alert");
	}
	
	public static void confirmAlert(By locator) {
		UIActionUtils.click(locator);
		ExtentTestManager.log.info("Clicked on the Button");
		//AlertManager.acceptAlert();
		AlertManager.dismissAlert();
		ExtentTestManager.log.info("Dismissed the Alert");
	}
	
	public static void promptAlert(By locator, String text) {
		UIActionUtils.click(locator);
		ExtentTestManager.log.info("Clicked on the Button");
		AlertManager.sendkeysAlert(text);
		ExtentTestManager.log.info("Entered the text : " +text);
		AlertManager.acceptAlert();
	}

}
