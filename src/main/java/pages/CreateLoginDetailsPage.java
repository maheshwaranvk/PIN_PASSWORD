package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import base.ProjectSpecificMethods;

public class CreateLoginDetailsPage extends ProjectSpecificMethods{

	public CreateLoginDetailsPage enterUserID(String intnID) {
		locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_userId").sendKeys("AA"+intnID);
		return this;
	}
	
	public CreateLoginDetailsPage enterPassword() {
		locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_password").sendKeys("August13!!");
		return this;
	}
	
	public CreateLoginDetailsPage reEnterPassword() {
		locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_reEnterPassword").sendKeys(
				  "August13!!");
		return this;
		}
	
	public CreateLoginDetailsPage enterVoicePin() {
		locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_voicePin").sendKeys("9629433877");
		return this;
	}
	
	public CreateLoginDetailsPage reEnterVoicePin() {
		locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_reEnterVoicePin").sendKeys("9629433877"
				  );
		return this;
	}
	
	public EnterSecurityQuestionsPage clickContinue() {
		locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_Continue").click();
		return new EnterSecurityQuestionsPage();
	}
	  public CreateLoginDetailsPage addScreenshot() throws WebDriverException, IOException
	  {
	  
	  String img = getScreenshotdriver(Integer.toString(createRandomNumber()));
	  reportStatus("Login Details updated Successfully", "pass", img); return
	  this; }
}
