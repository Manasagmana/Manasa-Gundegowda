package Pages;

import Initialise.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BaseTest{
	
	@AndroidFindBy (id = "income_button_title") private MobileElement homePageItem;
	@AndroidFindBy(id = "income_button") private MobileElement incomeButton;
	@AndroidFindBy(id = "expense_button") private MobileElement expenseButton;
	
	
public String getTitle() {
		
		return getAttribute(homePageItem, "text");
		
	}

public IncomePage pressIncome() {
	click(incomeButton);
	return new IncomePage();
	
}

public ExpensePage pressExpense() {
	click(expenseButton);
	return new ExpensePage();
	
}
	


}
