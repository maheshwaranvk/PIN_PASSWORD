package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import base.ProjectSpecificMethods;


public class LoginPage extends ProjectSpecificMethods{

	public LoginPage enterTestCnfg() {
		locateElement("id", "_ParticipantLogon20_WAR_ahcommonauthportlet_testCfgList[0].cfgValue").sendKeys("WB0B");
		return this;
	}
	
	public LoginPage enterTestCnfgYSA() {
		locateElement("id", "_ParticipantLogon20_WAR_ahcommonauthportlet_testCfgList[1].cfgValue").sendKeys("M6HB");
		return this;
	}
	
	public LoginPage clickRSA() {
		locateElement("xpath", "(//span[@class='aui-field-element aui-field-label-right'])[2]").click();
		return this;
	}
	
	public LoginPage enterUDPSchema() {
		locateElement("id", "_ParticipantLogon20_WAR_ahcommonauthportlet_udpSchema").sendKeys("Z001250Z");
		return this;
	}
	public LoginPage takeScreenshotLoginPage() throws WebDriverException, IOException {
		getScreenshotdriver("LoginPage");
		reportStatus("LoginPage Data Entered Successfully", "pass", "LoginPage");
		return this;
	}
	
	public CredentialsPage clickNewUser() {
		locateElement("xpath", "//a[text()='New User?']").click();
		return new CredentialsPage();

	}
	
}
