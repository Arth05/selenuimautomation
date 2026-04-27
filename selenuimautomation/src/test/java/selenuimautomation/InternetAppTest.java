package selenuimautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import managers.DriverManager;
import pageclasses.AlertPage;
import pageclasses.DragNdropPage;
import pageclasses.HomePage;
import pageclasses.LoginPage;
import utils.BaseUtils;
import utils.UIActionUtils;

public class InternetAppTest extends BaseTest {

	@Test
	public void loginForm() {
		By page = By.linkText("Form Authentication");
		By username = By.id("username");
		By password = By.id("password");
		By loginButton = By.className("radius");

		DriverManager.initDriver();
		DriverManager.getUrl("https://the-internet.herokuapp.com/");

		HomePage.nextPage(page);
		LoginPage.sendKeys(username, BaseUtils.getProperty("username"));
		LoginPage.sendKeysPassword(password, BaseUtils.getProperty("password"));
		LoginPage.click(loginButton);

		String actualUrl = DriverManager.getDriver().getCurrentUrl();
		String expectedUrl = "https://the-internet.herokuapp.com/secure";

		Assert.assertEquals(actualUrl, expectedUrl);

		DriverManager.exitDriver();
	}

	@Test
	public void dragAndDrop() {
		By page = By.linkText("Drag and Drop");
		DriverManager.initDriver();
		DriverManager.getUrl("https://the-internet.herokuapp.com/");
		HomePage.nextPage(page);
		WebElement source = DriverManager.getDriver().findElement(By.id("column-a"));
		WebElement target = DriverManager.getDriver().findElement(By.id("column-b"));
		DragNdropPage.performAction(source, target);

		String textA = DriverManager.getDriver().findElement(By.xpath("//div[@id='column-a']/header")).getText();
		String textB = DriverManager.getDriver().findElement(By.xpath("//div[@id='column-b']/header")).getText();

		Assert.assertEquals(textA, "B");
		Assert.assertEquals(textB, "A");
		DriverManager.exitDriver();

	}

	@Test
	public void simpleAlert() {

		By page = By.linkText("JavaScript Alerts");
		By button = By.xpath("//button[text()='Click for JS Alert']");
		By verify = By.id("result");

		DriverManager.initDriver();
		DriverManager.getUrl("https://the-internet.herokuapp.com/");
		HomePage.nextPage(page);
		AlertPage.basicAlert(button);
		Assert.assertEquals(UIActionUtils.resultText(verify), "You successfully clicked an alert");
		DriverManager.exitDriver();

	}
	
	@Test
	public void confirmationAlert() {
		
		By page = By.linkText("JavaScript Alerts");
		By button = By.xpath("//button[text()='Click for JS Confirm']");
		By verify = By.id("result");

		DriverManager.initDriver();
		DriverManager.getUrl("https://the-internet.herokuapp.com/");
		HomePage.nextPage(page);
		AlertPage.confirmAlert(button);
		Assert.assertEquals(UIActionUtils.resultText(verify), "You clicked: Cancel");
		DriverManager.exitDriver();
		
	}
	
	@Test
	public void JSpromptAlert() {
		
		By page = By.linkText("JavaScript Alerts");
		By button = By.xpath("//button[text()='Click for JS Prompt']");
		By verify = By.id("result");
		String text = BaseUtils.getProperty("text");
		
		DriverManager.initDriver();
		DriverManager.getUrl("https://the-internet.herokuapp.com/");
		HomePage.nextPage(page);
		AlertPage.promptAlert(button, text);
		Assert.assertEquals(UIActionUtils.resultText(verify), "You entered: " +text);
		DriverManager.exitDriver();
		
	}

}
