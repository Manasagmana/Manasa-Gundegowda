package tests;

import org.testng.annotations.Test;

import Initialise.BaseTest;
import Pages.HomePage;
import Pages.OnboardingPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;

public class OnboardingTest extends BaseTest {
	
	OnboardingPage onboardingPage;
	HomePage homePage;
	
	@BeforeClass
	  public void beforeClass() {
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  onboardingPage = new OnboardingPage();
		 
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }
	  
  @Test
  public void continueNext() {
  onboardingPage.pressContinue();
 
	  
  }
  
  @Test
  public void homePageLanding() {
	  homePage = onboardingPage.popUp();
	  
	  String actualTitle = homePage.getTitle();
	  String expectedTitle = strings.get("homeTitle");
	  System.out.println("ActualTitle -" + actualTitle + "\n" + "ExpectedTitle -" + expectedTitle);
	 assertEquals(actualTitle, expectedTitle);
	  
	  
  }
  
 

  

}
