package pages;

import base.ProjectSpecificMethods;

public class ChangePassword extends ProjectSpecificMethods{

	public ChangePassword enterCurrentPassword() {
		locateElement("id", "_CredentialChange20_WAR_ahcommonauthportlet_currPass").sendKeys("August13!!");
		return this;
	}
	
	public ChangePassword enterNewPassword() {
		locateElement("id", "_CredentialChange20_WAR_ahcommonauthportlet_newPass").sendKeys("IwillbeStrong#!");
		return this;

	}
	
	public ChangePassword reenterNewPassword() {
		locateElement("id", "_CredentialChange20_WAR_ahcommonauthportlet_reEnter").sendKeys("IwillbeStrong#!");
		return this;
	}
	
	public CSPasswordPage clickChangePassword() {
		locateElement("xpath", "//input[@class='aui-button-input aui-button-input-submit']").click();
		return new CSPasswordPage();
	}
	
	
}
