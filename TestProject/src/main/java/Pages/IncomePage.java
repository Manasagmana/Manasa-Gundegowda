package Pages;

import Initialise.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class IncomePage extends BaseTest {
	
	@AndroidFindBy (id = "amount_text") private MobileElement amountField ;
	@AndroidFindBy (id = "textViewNote") private MobileElement noteField ;
	@AndroidFindBy (id = "keyboard_action_button") private MobileElement chooseCategory ;
	
	public IncomePage amountEnter(String amount) {
		
		sendKeys(amountField, amount);
		return this;
	}
	
	public IncomePage enterNote(String note) {
		
		sendKeys(noteField, note);
		return this;
	}
	
	public IncomeCategory selectCategory() {
		click(chooseCategory);
		return new IncomeCategory();
		
	}

}
