package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import managers.DriverManager;
import managers.WaitManager;

public class UIActionUtils {

	private static Actions act;

	public static void click(By locator) {
		WaitManager.initWait();
		WaitManager.elementToBeClickable(locator).click();
	}

	public static void sendKeys(By locator, String text) {
		WaitManager.initWait();
		WaitManager.elementToBeVisibile(locator).sendKeys(text);
	}

	public static void initAction(WebElement source, WebElement target) {

		WaitManager.initWait();
		WaitManager.elementToBeClickable(source);
		WaitManager.elementToBeClickable(target);
		act = new Actions(DriverManager.getDriver());
		act.clickAndHold(source).pause(Duration.ofSeconds(1)).moveToElement(target).release().build().perform();
	}

	public static String resultText(By locator) {

		return DriverManager.getDriver().findElement(locator).getText();

	}

}
