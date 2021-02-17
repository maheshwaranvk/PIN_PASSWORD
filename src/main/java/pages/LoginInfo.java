package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import base.ProjectSpecificMethods;

public class LoginInfo extends ProjectSpecificMethods{

	public ChangeUserID clickUserIDChange() {
		locateElement("xpath", "(//input[@class='aui-button-input'])[1]").click();
		return new ChangeUserID();
	}
	
	public ChangePassword clickPasswordChange() {
		locateElement("xpath", "(//input[@class='aui-button-input'])[2]").click();
		return new ChangePassword();
	}
	
	public LoginInfo addScreenshot() throws WebDriverException, IOException
	  {
	  
	  String img = getScreenshotdriver(Integer.toString(createRandomNumber()));
	  reportStatus("Login Information Page Loaded Successfully", "pass", img); 
	  return
	  this; }
}
