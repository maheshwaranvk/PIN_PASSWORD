package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;

public class EnterSecurityQuestionsPage extends ProjectSpecificMethods{

	public EnterSecurityQuestionsPage ansQuestion() {
		
		 selectDropDown(new Select(locateElement("xpath",
				  "(//select[@class='aui-field-input aui-field-input-select aui-field-input-menu'])[1]"
				  )), "index", "1"); locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_securityAns1").sendKeys("TEST");
				  
				  selectDropDown(new Select(locateElement("xpath",
				  "(//select[@class='aui-field-input aui-field-input-select aui-field-input-menu'])[2]"
				  )), "index", "2"); locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_securityAns2").sendKeys("TEST");
				  
				  selectDropDown(new Select(locateElement("xpath",
				  "(//select[@class='aui-field-input aui-field-input-select aui-field-input-menu'])[3]"
				  )), "index", "3"); locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_securityAns3").sendKeys("TEST");
				  
				  selectDropDown(new Select(locateElement("xpath",
				  "(//select[@class='aui-field-input aui-field-input-select aui-field-input-menu'])[4]"
				  )), "index", "4"); locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_securityAns4").sendKeys("TEST");
				  
				  selectDropDown(new Select(locateElement("xpath",
				  "(//select[@class='aui-field-input aui-field-input-select aui-field-input-menu'])[5]"
				  )), "index", "5"); locateElement("id",
				  "_ParticipantLogon20_WAR_ahcommonauthportlet_securityAns5").sendKeys("TEST");

				  return this;
	}
	
	public RSAVerificationPage clickContinueESQ() {
		locateElement("xpath", "//input[@class='aui-button-input aui-button-input-submit']").click();
		return new RSAVerificationPage();
	}
	
	public EnterSecurityQuestionsPage addScreenshot() throws WebDriverException, IOException
	  {
	  
	  String img = getScreenshotdriver(Integer.toString(createRandomNumber()));
	  reportStatus("Security Questions answered Successfully", "pass", img); 
	  return
	  this; }
	
}
