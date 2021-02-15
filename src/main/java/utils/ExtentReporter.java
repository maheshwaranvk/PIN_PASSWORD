package utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public static ExtentTest newUser;
	
	@BeforeSuite
	public void executeReportLevel() {
		reporter = new ExtentSparkReporter("./reports/result.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
		@BeforeTest
		public void executeTestLevel() {
		newUser = extent.createTest("TC001_newUser?", "This Test Case will check for new User link in LoginPage");
		newUser.assignAuthor("Maheshwaran");
		newUser.assignCategory("UnitTesting");
		newUser.assignDevice("Windows 10");
	}
		
	@AfterSuite
	public void closeFlush() {
		extent.flush();
	}

}
