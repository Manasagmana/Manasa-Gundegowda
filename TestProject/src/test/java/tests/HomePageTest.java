package tests;

import org.testng.annotations.Test;

import Initialise.BaseTest;
import Pages.ExpensePage;
import Pages.Expensecategory;
import Pages.HomePage;
import Pages.IncomeCategory;
import Pages.IncomePage;
import Pages.OnboardingPage;
import utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;

import org.json.JSONObject;
import org.json.JSONTokener;

public class HomePageTest extends BaseTest {
	
	OnboardingPage onboardingPage;
	HomePage homePage;
	IncomePage incomePage;
	IncomeCategory incomeCategory;
	ExpensePage expensePage;
	Expensecategory expensecategory;
	
	JSONObject amountDetails;
	TestUtils utils = new TestUtils();
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		
		InputStream datais = null;
		  try {
			  String dataFileName = "data/loginUsers.json";
			  datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			  JSONTokener tokener = new JSONTokener(datais);
			  amountDetails = new JSONObject(tokener);
		  } catch(Exception e) {
			  e.printStackTrace();
			  throw e;
		  } finally {
			  if(datais != null) {
				  datais.close();
			  }
		  }
		
		closeApp();
		launchApp();
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  
		  onboardingPage = new OnboardingPage();
		  homePage = new HomePage();
		  incomePage = new IncomePage();
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }
	  
  
  
  @Test
  public void incomeAddition() {
	onboardingPage.onboarding();
	
	incomePage = homePage.pressIncome();
	incomePage.amountEnter(amountDetails.getJSONObject("incomeDetail").getString("amount"));
	incomePage.enterNote(amountDetails.getJSONObject("incomeDetail").getString("note"));
	
	incomeCategory = incomePage.selectCategory();
	
	  String actualTitle = homePage.getTitle();
	  String expectedTitle = strings.get("homeTitle");
	  System.out.println("ActualTitle -" + actualTitle + "\n" + "ExpectedTitle -" + expectedTitle);
	  assertEquals(actualTitle, expectedTitle);
  }
  
  @Test
  public void expenseAddition() {
	
	  expensePage = homePage.pressExpense();
	  expensePage.amountEnter(amountDetails.getJSONObject("expenseDetail").getString("amountExpense"));
	  expensePage.enterNote(amountDetails.getJSONObject("expenseDetail").getString("noteExpense"));
	  
	  expensecategory = expensePage.selectCategory();
	
	  String actualTitle = homePage.getTitle();
	  String expectedTitle = strings.get("homeTitle");
	  System.out.println("ActualTitle -" + actualTitle + "\n" + "ExpectedTitle -" + expectedTitle);
	  assertEquals(actualTitle, expectedTitle);
  }
  

}
