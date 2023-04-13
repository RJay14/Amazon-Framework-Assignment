package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;

public class pomCart extends BaseAmazonClass{

	@FindBy (id = "add-to-cart-button") WebElement addtoCartBtn;
	@FindBy (id = "nav-cart") WebElement viewCart;
	@FindBy (id = "a-autoid-1-announce") WebElement quantityDD;
	
	public pomCart() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddtoCartBtn() {
		addtoCartBtn.click();
	}
	
	public void gotoCart() {
		viewCart.click();
	}
	
	public void updateQuantity() {
		quantityDD.click();
		driver.findElement(By.xpath("//* [text() = '2']")).click();
	}
}
