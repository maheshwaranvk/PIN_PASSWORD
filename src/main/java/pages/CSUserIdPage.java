package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import base.ProjectSpecificMethods;
import testCases.VCCLinks;

public class CSUserIdPage extends ProjectSpecificMethods{

	public LoginInfo clickLoginInfor() {
		locateElement("xpath", "(//a[text()='Log In Information'])[3]").click();
		return new LoginInfo();

	}
	
	public CSUserIdPage addScreenshot() throws WebDriverException, IOException
	  {
	  
	  String img = getScreenshotdriver(Integer.toString(createRandomNumber()));
	  reportStatus("User ID Changed Successfully", "pass", img); 
	  return
	  this; }
	
}
