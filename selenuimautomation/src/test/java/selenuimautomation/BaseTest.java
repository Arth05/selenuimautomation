package selenuimautomation;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.MediaEntityBuilder;

import managers.DriverManager;
import managers.ExtentManager;
import managers.ExtentTestManager;
import utils.BaseUtils;

public class BaseTest {

	@BeforeSuite
	public void initialise() {
		ExtentManager.initReport();
	}

	@BeforeMethod
	public void preReq(Method method) {
		ExtentTestManager.createTest(method.getName());
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {

			ExtentTestManager.log.pass("Test Passed");

		} else if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotName = result.getInstance().getClass().getSimpleName() + "."
					+ result.getMethod().getMethodName();

			String screenshotPath = BaseUtils.getScreenShotPath(DriverManager.getDriver(), screenshotName);

			ExtentTestManager.log.fail(result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		}

		else if (result.getStatus() == ITestResult.SKIP) {

			ExtentTestManager.log.skip("Test Skipped");
		}

	}

	@AfterSuite
	public void tearDown() {
		ExtentManager.flushReport();
	}
}
