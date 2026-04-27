package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.BaseUtils;

public class DriverManager {

    public static WebDriver driver;

    public static void initDriver() {

        String browser = BaseUtils.getProperty("browser");

        switch (browser.toLowerCase()) {

        case "chrome":
            driver = new ChromeDriver();
            ExtentTestManager.log.info("Chrome Browser is opened successfully");

            break;

        case "firefox":
            driver = new FirefoxDriver();
            ExtentTestManager.log.info("Firefox Browser is opened successfully");

            break;

        case "edge":
            driver = new EdgeDriver();
            ExtentTestManager.log.info("Edge Browser is opened successfully");

            break;

        default:
            System.out.println("Browser not supported");
            ExtentTestManager.log.info("Browser is not supported");

            break;
        }

        driver.manage().window().maximize();
        ExtentTestManager.log.info("Browser window is maximized");

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void getUrl(String url) {
        driver.get(url);
        ExtentTestManager.log.info("URL : " + url + " opened");

    }

    public static void exitDriver() {
        if (driver != null) {
            driver.quit();
            ExtentTestManager.log.info("Browser is closed");
        }
    }
}
	
