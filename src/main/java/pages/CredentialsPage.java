package pages;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;

public class CredentialsPage extends ProjectSpecificMethods{

	public CredentialsPage enterSSN(String prsnID) {
		locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_PersonalIdentificationField[0].UsrValue")
				  .sendKeys(prsnID);
		return this;
	}
	
	public CredentialsPage enterDOB(String dateOfBirth) throws ParseException {
		locateElement("xpath", "//select[@class='aui-datepicker-month']");
		DOBConversion(dateOfBirth);		  
		  selectDropDown(new Select(locateElement("xpath",
		  "//select[@class='aui-datepicker-month']")), "index", month);
		  selectDropDown(new Select(locateElement("xpath",
		  "//select[@class='aui-datepicker-day']")), "index", day);
		  selectDropDown(new Select(locateElement("xpath",
		  "//select[@class='aui-datepicker-year']")), "visibleText", year);
		  
		  return this;
	}
	
	public EnterZipPage clickSubmit() {
		 locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_Continue").click();
		 return new EnterZipPage();
		 }
	
	
	  public CredentialsPage addScreenshot() throws WebDriverException, IOException
	  {
	  
	  String img = getScreenshotdriver(Integer.toString(createRandomNumber()));
	  reportStatus("Credential Page Loaded Successfully", "pass", img); return
	  this; }
	 
	
}
