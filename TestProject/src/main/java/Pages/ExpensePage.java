package Pages;

import Initialise.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExpensePage extends BaseTest {
	
	@AndroidFindBy (id = "amount_text") private MobileElement expenseAmount ;
	@AndroidFindBy (id = "textViewNote") private MobileElement expenseNote ;
	@AndroidFindBy (id = "keyboard_action_button") private MobileElement expenseCategory ;
	
public ExpensePage amountEnter(String amountExpense) {
		
		sendKeys(expenseAmount, amountExpense);
		return this;
	}
	
	public ExpensePage enterNote(String noteExpense) {
		
		sendKeys(expenseNote, noteExpense);
		return this;
	}
	
	public Expensecategory selectCategory() {
		click(expenseCategory);
		return new Expensecategory();
		
	}

}
