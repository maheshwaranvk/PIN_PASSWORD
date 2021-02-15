package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import base.ProjectSpecificMethods;

public class EnterZipPage extends ProjectSpecificMethods{

	public EnterZipPage enterZip(String zipCd) {
		 locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_PersonalFieldObject[0].UsrValue")
				  .sendKeys(zipCd);
		 return this;
	}
	
	public CreateLoginDetailsPage clickContinue() {
		locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_Continue").click();
		return new CreateLoginDetailsPage();

	}
	
	  public EnterZipPage addScreenshot() throws WebDriverException, IOException
	  {
	  
	  String img = getScreenshotdriver(Integer.toString(createRandomNumber()));
	  reportStatus("Add Zip Page Loaded Successfully", "pass", img); 
	  return
	  this; }
}
