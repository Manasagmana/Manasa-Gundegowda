package Initialise;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import utils.TestUtils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {
	
	protected static AppiumDriver driver;
	protected static Properties props;
	protected static  HashMap<String, String> strings = new HashMap<String, String>();
  InputStream inputStream;
  InputStream stringsis;
	TestUtils utils;
  
  public BaseTest() {
	  
	  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	  
	  
  }
  
  
  @Parameters({"platformName", "platformVersion", "deviceName", "deviceId"})
  @BeforeTest
  public void beforeTest(String platformName, String platformVersion, String deviceName, String deviceId) throws Exception {
	  
	  try {
		  
		  props = new Properties();
		  String propFileName = "config.properties";
		  
		  inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		  props.load(inputStream);
		  String xmlFileName = "Strings/strings.xml";
		  
		  stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
		  utils = new TestUtils();
		  strings = utils.parseStringXML(stringsis);

		  DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			cap.setCapability(MobileCapabilityType.UDID, deviceId);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
		

			cap.setCapability("appPackage", props.getProperty("androidAppPackage"));
			cap.setCapability("appActivity", props.getProperty("androidAppActivity"));
			

			URL url = new URL(props.getProperty("appiumURL"));

			driver = new AppiumDriver<MobileElement>(url, cap);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	  finally {
		  if(inputStream != null) {
			  inputStream.close();
		  }
		  if(stringsis != null) {
			  stringsis.close();
		  }
	  }
  
  
  }
  
  public void waitForVisibility(MobileElement e) {
		
	  WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
	  wait.until(ExpectedConditions.visibilityOf(e));
	  
}
  
  public void click(MobileElement e) {
	  waitForVisibility(e);
	  e.click();
	  
  }
  
  public void sendKeys(MobileElement e, String txt) {
	waitForVisibility(e);
	e.sendKeys(txt);
}
  
  public String getAttribute(MobileElement e, String attribute) {
	  waitForVisibility(e);
	return e.getAttribute(attribute);
}
  
public void tap(MobileElement e) {
	  
	  TouchAction touchAction = new TouchAction(driver);
	  touchAction.tap(TapOptions.tapOptions().withTapsCount(3).withElement(ElementOption.element(e))).perform();
	  
  }

public void closeApp() {
	((InteractsWithApps) driver).closeApp();
}

public void launchApp() {
	((InteractsWithApps) driver).launchApp();
}
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
