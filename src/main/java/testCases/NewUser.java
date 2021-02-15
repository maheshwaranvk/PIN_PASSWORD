package testCases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class NewUser extends ProjectSpecificMethods {

	
	  @BeforeTest public void getExcelFileName() { excelFileName="NewUser";
	  
	  }
	 

	@Test(dataProvider = "fetchData")
	public void runNewUser(String intnID, String dateOfBirth, String zipCd, String prsnID) throws ParseException, WebDriverException, IOException {

		
		  new LoginPage().enterTestCnfg() .enterTestCnfgYSA() .enterUDPSchema()
		  .clickNewUser() 
		  .enterSSN(prsnID) .enterDOB(dateOfBirth).addScreenshot()
		  .clickSubmit() 
		  .enterZip(zipCd).addScreenshot()
		  .clickContinue() .enterUserID(intnID) .enterPassword() .reEnterPassword()
		  .enterVoicePin() .reEnterVoicePin() .addScreenshot()
		  .clickContinue() .ansQuestion().addScreenshot()
		  .clickContinueESQ() .addScreenshot()
		  .clickContinuRSA() .addScreenshot()
		  .clickContinueLS()
		  .checkHomePageLoaded()
		  .verifyTitle() .addScreenshot()
		  ;

	}
}
