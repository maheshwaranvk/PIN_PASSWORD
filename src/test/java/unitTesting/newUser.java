package unitTesting;

import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.MemberSubstitution.TypePoolResolver.OfImplicitPool;
import utils.WrapperClass;

public class newUser extends WrapperClass {

	@Test
	public void newUserLogin() throws IOException, ParseException, InterruptedException {
		
		newUser nU = new newUser();
		nU.launchBrowser("chrome", "http://digital.qc.alight.com/hilton/");

		SoftAssert sa = new SoftAssert();
		// LoginPage

		nU.locateElement("id", "_ParticipantLogon20_WAR_ahcommonauthportlet_testCfgList[0].cfgValue").sendKeys("WB0B");
		nU.locateElement("id", "_ParticipantLogon20_WAR_ahcommonauthportlet_testCfgList[1].cfgValue").sendKeys("M6HB");
		nU.locateElement("xpath", "(//span[@class='aui-field-element aui-field-label-right'])[2]").click();
		nU.locateElement("id", "_ParticipantLogon20_WAR_ahcommonauthportlet_udpSchema").sendKeys("Z001250Z");
		
		nU.getScreenshotdriver("LoginPage");
		nU.reportStatus("LoginPage Data Entered Successfully", "pass", "LoginPage");

		nU.locateElement("xpath", "//a[text()='New User?']").click();
		  
		String ssn = "0088" ; 
		String zip="35206" ;
		String INTN="139310088";
		String dob = "12/13/1978";
		
		SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
		Date date1=date.parse(dob);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)-1);
		String month = String.valueOf(cal.get(Calendar.MONTH));
		String year = String.valueOf(cal.get(Calendar.YEAR));
		
		System.out.println(day+": Day");
		System.out.println(month+": Month");
		System.out.println(year+": Year");
		
			  
		
		  // InformationPage 
		
		nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_PersonalIdentificationField[0].UsrValue")
		  .sendKeys(ssn);
		  
		  nU.locateElement("xpath", "//select[@class='aui-datepicker-month']");
		  
		  nU.selectDropDown(new Select(nU.locateElement("xpath",
		  "//select[@class='aui-datepicker-month']")), "index", month);
		  nU.selectDropDown(new Select(nU.locateElement("xpath",
		  "//select[@class='aui-datepicker-day']")), "index", day);
		  nU.selectDropDown(new Select(nU.locateElement("xpath",
		  "//select[@class='aui-datepicker-year']")), "visibleText", year);
		
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_Continue").click();
		 
		  
		 
		  
		
		  // ZipPage
		  
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_PersonalFieldObject[0].UsrValue")
		  .sendKeys(zip); nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_Continue").click();
		  
		  
		  // UpdateLoginInfoPage
		  
		  String reqHeaderText =
		  "A user ID is an ID that uniquely identifies you on this site. Your user ID gives you access to your benefits information while protecting the confidentiality of your Social Security Number."
		  ; String headerText = nU.locateElement("xpath",
		  "//p[@class='ah-content-space-v']").getText(); // VerifyHeaderText
		  sa.assertTrue(headerText.equals(reqHeaderText));
		  
		  // VerifyUserNameLength
		  
		  String reqUserNameLength = "Enter 8 to 60 characters."; String userNameLength
		  = nU.locateElement("xpath",
		  "(//div[@id='specialCharEdit']//following::li)[1]").getText();
		  sa.assertTrue(userNameLength.equals(reqUserNameLength));
		  
		  // VerifyPasswordLength
		  
		  String reqPasswordLength = "Within 10 - 20 characters"; String passwordLength
		  = nU.locateElement("xpath",
		  "(//span[@id='passFailImage0']//following::span)[1]") .getText();
		  sa.assertTrue(passwordLength.equals(reqPasswordLength));
		  
		  // VerifyPinLength
		  
		  String reqPinLength = "Within 6 - 12 numbers"; String pinLength =
		  nU.locateElement("xpath",
		  "(//span[@id='passFailImage6']//following::span)[1]").getText();
		  sa.assertTrue(pinLength.equals(reqPinLength));
		  
		  // NegativeTesting 
		  
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_userId").sendKeys("A"+INTN);
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_password").sendKeys("August13!")
		  ; nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_reEnterPassword").clear();
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_reEnterPassword").sendKeys(
		  "August13!"); nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_voicePin").sendKeys("962");
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_reEnterVoicePin").clear();
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_reEnterVoicePin").sendKeys("962"
		  ); nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_Continue").click();
		  sa.assertTrue(nU.locateElement("xpath",
		  "//strong[@class='ah-error-message ah-font-m']").isEnabled());
		  
		  // EnterUser Name 
		  
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_userId").clear();
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_userId").sendKeys("AA"+INTN);
		  
		  // VerifyPasswordCharacters 
		  
		  String newPassword = "August13!!";
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_password").clear();
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_password").sendKeys(newPassword)
		  ; char[] newPassword1 = newPassword.toCharArray();
		  
		  if (newPassword.length() >= 10 && newPassword.length() <= 20) {
		  sa.assertTrue(nU.locateElement("xpath",
		  "//span[@id='passFailImage0']//img[@src='/ah-commonauth-portlet/images/icon/icon_check_small_checked.png']")
		  .isEnabled()); }
		  
		  for (int i = 0; i < newPassword1.length; i++) {
		  
		  if (Character.isUpperCase(newPassword1[i])) {
		  sa.assertTrue(driver.findElementByXPath(
		  "//span[@id='passFailImage2']//img[@src='/ah-commonauth-portlet/images/icon/icon_check_small_checked.png']")
		  .isEnabled()); } else if (Character.isLowerCase(newPassword1[i])) {
		  sa.assertTrue(driver.findElementByXPath(
		  "//span[@id='passFailImage3']//img[@src='/ah-commonauth-portlet/images/icon/icon_check_small_checked.png']")
		  .isEnabled()); } else if (Character.isDigit(newPassword1[i])) {
		  sa.assertTrue(driver.findElementByXPath(
		  "//span[@id='passFailImage5']//img[@src='/ah-commonauth-portlet/images/icon/icon_check_small_checked.png']")
		  .isEnabled()); } }
		  
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_reEnterPassword").sendKeys(
		  newPassword); sa.assertTrue(nU.locateElement("xpath",
		  "//span[@id='passFailImage2']//img[@src='/ah-commonauth-portlet/images/icon/icon_check_small_checked.png']")
		  .isEnabled());
		  
		  // VerifyPinCharacters
		  
		  String PIN = "962943"; nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_voicePin").clear();
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_voicePin").sendKeys(PIN); if
		  (PIN.length() >= 6 && PIN.length() <= 12) {
		  sa.assertTrue(nU.locateElement("xpath",
		  "//span[@id='passFailImage6']//img[@src='/ah-commonauth-portlet/images/icon/icon_check_small_checked.png']")
		  .isEnabled()); }
		  
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_reEnterVoicePin").sendKeys(PIN);
		  sa.assertTrue(nU.locateElement("xpath",
		  "//span[@id='passFailImage7']//img[@src='/ah-commonauth-portlet/images/icon/icon_check_small_checked.png']")
		  .isEnabled());
		  
		  nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_Continue").click();
		  
		  nU.selectDropDown(new Select(nU.locateElement("xpath",
		  "(//select[@class='aui-field-input aui-field-input-select aui-field-input-menu'])[1]"
		  )), "index", "1"); nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_securityAns1").sendKeys("TEST");
		  
		  nU.selectDropDown(new Select(nU.locateElement("xpath",
		  "(//select[@class='aui-field-input aui-field-input-select aui-field-input-menu'])[2]"
		  )), "index", "2"); nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_securityAns2").sendKeys("TEST");
		  
		  nU.selectDropDown(new Select(nU.locateElement("xpath",
		  "(//select[@class='aui-field-input aui-field-input-select aui-field-input-menu'])[3]"
		  )), "index", "3"); nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_securityAns3").sendKeys("TEST");
		  
		  nU.selectDropDown(new Select(nU.locateElement("xpath",
		  "(//select[@class='aui-field-input aui-field-input-select aui-field-input-menu'])[4]"
		  )), "index", "4"); nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_securityAns4").sendKeys("TEST");
		  
		  nU.selectDropDown(new Select(nU.locateElement("xpath",
		  "(//select[@class='aui-field-input aui-field-input-select aui-field-input-menu'])[5]"
		  )), "index", "5"); nU.locateElement("id",
		  "_ParticipantLogon20_WAR_ahcommonauthportlet_securityAns5").sendKeys("TEST");
		  
		  nU.locateElement("xpath", "//input[@class='aui-button-input aui-button-input-submit']").click();
		  nU.locateElement("xpath", "//input[@class='aui-button-input aui-button-input-submit']").click();
		  
		  
		  //VerifyLogOnSuccessPage
		  
		  
		  String logOnSuccessActual = nU.locateElement("xpath", "(//div[@class='ah-auth-header']/following::p)[1]").getText();
		  String logOnSuccessExpected ="Your Log On Information has been updated successfully.";
		  sa.assertTrue(logOnSuccessActual.equals(logOnSuccessExpected));
		  
		  nU.locateElement("id", "_ParticipantLogon20_WAR_ahcommonauthportlet_Continue").click();
		  
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alDialogCloseBtn")));
		  
		  
		  String homePage = driver.getTitle();
		  sa.assertTrue(homePage.contains("Home"));
		  
		  
		  sa.assertAll();
		 
		 
		 

	}
}
