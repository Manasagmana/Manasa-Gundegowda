package Pages;

import Initialise.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Expensecategory extends BaseTest {
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.GridView/android.widget.FrameLayout[2]/android.widget.LinearLayout\n"
			+ "") private MobileElement carExpense ;
	@AndroidFindBy (id = "income_button_title") private MobileElement homePageItem;
	
	public HomePage expenseCar() {
		click(carExpense);
		return new HomePage();
		
	}
	
public String getTitle() {
		
		return getAttribute(homePageItem, "text");
		
	}

}
