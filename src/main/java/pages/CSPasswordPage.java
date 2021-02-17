package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import base.ProjectSpecificMethods;
import testCases.VCCLinks;

public class CSPasswordPage extends ProjectSpecificMethods{

	public void clickLoginInfor() {
		locateElement("xpath", "(//a[text()='Log In Information'])[3]").click();

	}
	
	public CSPasswordPage addScreenshot() throws WebDriverException, IOException
	  {
	  
	  String img = getScreenshotdriver(Integer.toString(createRandomNumber()));
	  reportStatus("Password Changed Successfully", "pass", img); 
	  return
	  this; }
}
