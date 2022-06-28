package Pages;

import Initialise.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;

public class OnboardingPage extends BaseTest {
	@AndroidFindBy (id = "buttonContinue") private MobileElement continueButton;
	@AndroidFindBy (id = "buttonClose") private MobileElement closeButton;

	public OnboardingPage pressContinue() {
	
		tap(continueButton);
	
		return this;
	}

	 public HomePage popUp() {
		 
		 click(closeButton);
		 return new HomePage();
		 
	 }
	 
	 public HomePage onboarding() {
		 pressContinue();
		return popUp();
		 
	 }
	
	
}
