package managers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	
	public static void initReport() {
		
		String time = LocalDateTime.now().
				format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh.mm.ss a"));
		
		spark = new ExtentSparkReporter ("target/AutomationReport " + time + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		spark.config().setDocumentTitle("InternetHerokuApp");
		spark.config().setReportName("FormAuthenticationTest");
		spark.config().setTheme(Theme.STANDARD);
		
	}
	
	public static void flushReport() {
		extent.flush();
	}
}
