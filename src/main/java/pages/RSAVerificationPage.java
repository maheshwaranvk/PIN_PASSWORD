package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import base.ProjectSpecificMethods;

public class RSAVerificationPage extends ProjectSpecificMethods{

	public LoginSuccessfulPage clickContinuRSA() {
		locateElement("xpath", "//input[@class='aui-button-input aui-button-input-submit']").click();
		return new LoginSuccessfulPage();
	}
	public RSAVerificationPage addScreenshot() throws WebDriverException, IOException
	  {
	  
	  String img = getScreenshotdriver(Integer.toString(createRandomNumber()));
	  reportStatus("RSA Authenticated Successfully", "pass", img); 
	  return
	  this; }
}
