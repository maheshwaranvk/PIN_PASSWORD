package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrapperClass extends ExtentReporter {
	
	public static RemoteWebDriver driver;
	public static SoftAssert sa = new SoftAssert();

	public void launchBrowser(String browser, String url) throws IOException {

		if (browser.equalsIgnoreCase("chrome") == true) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox") == true) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			driver.get(url);
			File source = driver.getScreenshotAs(OutputType.FILE);
			File target = new File("./reports/LoginPage.png");
			FileUtils.copyFile(source, target);

			newUser.pass("Browser Launched", MediaEntityBuilder.createScreenCaptureFromPath("./LoginPage.png").build());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public WebElement locateElement(String att, String value) {
		switch (att) {

		case "id":
			return driver.findElementById(value);
		case "linkText":
			return driver.findElementByLinkText(value);
		case "xpath":
			return driver.findElementByXPath(value);
		case "className":
			return driver.findElementByClassName(value);
		default:
			return null;

		}
	}

	public List<WebElement> locateElements(String att, String value) {
		switch (att) {

		case "id":
			return driver.findElementsById(value);
		case "linkText":
			return driver.findElementsByLinkText(value);
		case "xpath":
			return driver.findElementsByXPath(value);
		case "className":
			return driver.findElementsByClassName(value);
		default:
			return null;
		}

	}

	public void click(WebElement ele) {
		ele.click();

	}

	public void sendKeys(WebElement ele, String value) {
		ele.sendKeys(value);

	}

	public void selectDropDown(Select ele, String selectType, String value) {
		if (selectType.equalsIgnoreCase("index") == true) {
			ele.selectByIndex(Integer.parseInt(value));
		} else if (selectType.equalsIgnoreCase("value") == true) {
			ele.selectByValue(value);
		} else if (selectType.equalsIgnoreCase("visibleText") == true)
			ele.selectByVisibleText(value);
	}

	public String getScreenshotdriver(String img) throws WebDriverException, IOException {
		{
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./reports/" + img + ".png"));
			return img;
		}
	}

	public void getScreenshotWebElement(WebElement ele, String img) throws WebDriverException, IOException {
		{
			FileUtils.copyFile(ele.getScreenshotAs(OutputType.FILE), new File("./reports/" + img + ".png"));
		}
	}
	
	public void reportStatus(String desc, String status, String img) {
		Media screenShot = MediaEntityBuilder.createScreenCaptureFromPath("./"+img+".png").build();
		if(status.equalsIgnoreCase("pass")) {
			newUser.pass(desc,screenShot);
		}else if(status.equalsIgnoreCase("fail")) {
			newUser.fail(desc,screenShot);
		}

	}
	
	public int createRandomNumber() {
		Random random=new Random();
		return random.nextInt(100000);

	}

}
