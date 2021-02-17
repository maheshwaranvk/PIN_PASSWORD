package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public HomePage checkHomePageLoaded() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alDialogCloseBtn")));
		  return this;

	}
	
	public HomePage verifyTitle() {
		String homePage = driver.getTitle();
		  sa.assertTrue(homePage.contains("Home"));
		  return this;
	}
	public HomePage addScreenshot() throws WebDriverException, IOException
	  {
	  
	  String img = getScreenshotdriver(Integer.toString(createRandomNumber()));
	  reportStatus("Login Successfully", "pass", img); 
	  return
	  this; }
	
	public HomePage closeGMC() {
		locateElement("id", "alDialogCloseBtn").click();
return this;
	}
	
	public HomePage clickLogInInfor() {
		locateElement("id", "al-aux-your-profile-aria-label").click();
		return this;
	}
	
	public LoginInfo clickLogin() {
		locateElement("xpath", "(//a[text()='Log In Information'])[1]").click();
		return new LoginInfo();

	}

}
