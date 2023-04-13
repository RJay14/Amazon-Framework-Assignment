package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;

public class pomYourOrders extends BaseAmazonClass{
	
	@FindBy(linkText = "Orders")WebElement OrdersView;
	@FindBy(linkText = "Buy Again") WebElement BuyAgainView;
	@FindBy(linkText = "Not Yet Shipped") WebElement NotShippedView;
	@FindBy(linkText = "Cancelled Orders") WebElement CancelledView;
	@FindBy(className = "a-dropdown-prompt") WebElement OrdersDropdown;
	@FindBy(css = "#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1) > a > div > div") WebElement YourOrdersButton;
	
	
	public pomYourOrders() {
		PageFactory.initElements(driver, this);
	}
	
	public void BuyAgain () {
		BuyAgainView.click();
	}
	
	public void NotShipped () {
		NotShippedView.click();
	}
	
	public void CancelledLink () {
		CancelledView.click();
	}
	
	public void Orders () {
		OrdersView.click();
	}
	
	public void YourOrdersButton() {
		YourOrdersButton.click();
	}
	
	public void Yourorderdropdown() {
		OrdersDropdown.click();
	}
	
	public WebElement order() {
		return OrdersDropdown;
	}

}
