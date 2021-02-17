package base;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import pages.CredentialsPage;
import utils.ReadExcelData;
import utils.WrapperClass;


public class ProjectSpecificMethods extends WrapperClass{

	
	/*
	 * public String ssn = "0029" ; public String zip="75040" ; public String
	 * INTN="297700029";
	 */
	/* public String dob = "01/25/1952"; */
	public static String day,month,year;
	 public String excelFileName; 
	 
	 public static String userID ;
	 public static String password ="August13!!";
	
	
	public void DOBConversion(String dob) throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");
		Date date1=date.parse(dob);
		
	
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)-1);
		month = String.valueOf(cal.get(Calendar.MONTH));
		year = String.valueOf(cal.get(Calendar.YEAR));
	}
	
	
	@BeforeMethod
	public void openBrowser() throws IOException {
		launchBrowser("chrome", "http://digital.qc.alight.com/hilton/");
	}
	
	@DataProvider(name="fetchData")
	public String[][] getExcelData() throws IOException {
		return ReadExcelData.readData(excelFileName);
		
	}
	

	
}
