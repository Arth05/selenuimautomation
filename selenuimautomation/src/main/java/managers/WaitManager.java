package managers;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitManager {

	private static WebDriverWait wait;
	

    public static void initWait() {
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
    }

    public static WebElement elementToBeVisibile(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement elementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static WebElement elementToBeClickable(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static Alert alertIsPresent() {
    	    initWait();
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    
    
    
    
    
	
}
