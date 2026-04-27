package selenuimautomation;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import managers.ExtentManager;
import managers.ExtentTestManager;

public class BaseTest {
	
	@BeforeSuite
	public void initialise () {
		ExtentManager.initReport();
	}
	
	@BeforeMethod
	public void preReq(Method method) {
		ExtentTestManager.createTest(method.getName());
	}

	@AfterSuite
	public void tearDown () {
		ExtentManager.flushReport();
	}
}
