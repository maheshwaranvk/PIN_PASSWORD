package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class VCCLinks extends ProjectSpecificMethods{

	@Test
	public void clickVccLinks() throws WebDriverException, IOException {
		new LoginPage().unCheckRSA().
		enterUserId(userID).enterPassword(password).enterTestCnfg().enterTestCnfgYSA().enterUDPSchema().	
		clickLogIn().checkHomePageLoaded().verifyTitle().closeGMC().clickLogInInfor().clickLogin().
		clickUserIDChange().enterCurrentPassword().enterNewUserID().clickChangeUserID().addScreenshot().
		clickLoginInfor().
		clickPasswordChange().enterCurrentPassword().
		enterNewPassword().reenterNewPassword().clickChangePassword().addScreenshot().
		clickLoginInfor();

	}
}
