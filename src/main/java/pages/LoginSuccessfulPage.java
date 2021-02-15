package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import base.ProjectSpecificMethods;

public class LoginSuccessfulPage extends ProjectSpecificMethods{

	public HomePage clickContinueLS() {
		locateElement("id", "_ParticipantLogon20_WAR_ahcommonauthportlet_Continue").click();
		return new HomePage();

	}
	
	public LoginSuccessfulPage addScreenshot() throws WebDriverException, IOException
	  {
	  
	  String img = getScreenshotdriver(Integer.toString(createRandomNumber()));
	  reportStatus("New User updated with Login Credentials Successfully", "pass", img); 
	  return
	  this; }
}
