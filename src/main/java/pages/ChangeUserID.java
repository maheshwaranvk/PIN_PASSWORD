package pages;

import base.ProjectSpecificMethods;
import testCases.VCCLinks;

public class ChangeUserID extends ProjectSpecificMethods{

	public ChangeUserID enterCurrentPassword() {
		locateElement("id", "_CredentialChange20_WAR_ahcommonauthportlet_pswd").sendKeys("August13!!");
		return this;
	}
	
	public ChangeUserID enterNewUserID() {
		locateElement("id", "_CredentialChange20_WAR_ahcommonauthportlet_newId").sendKeys("A"+userID);
		return this;
	}
	
	public CSUserIdPage clickChangeUserID() {
		locateElement("xpath", "//input[@class='aui-button-input aui-button-input-submit']").click();
		return new CSUserIdPage();

	}
	
	
}
