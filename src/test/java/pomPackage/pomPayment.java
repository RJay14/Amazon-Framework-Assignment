package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;

public class pomPayment extends BaseAmazonClass{
	
	@FindBy(css = "#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(2) > a") WebElement paymentsLink;
	@FindBy(linkText = "Add a payment method") WebElement addCardLink;
	@FindBy(xpath = "/html/body/div[1]/div[4]/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div/div[1]/span/span[1]/span/input") WebElement insertCardButton;
	@FindBy(name = "addCreditCardNumber") WebElement cardNum;
	@FindBy(name = "ppw-accountHolderName") WebElement nameOnCard;
	@FindBy(xpath =("//*[text()='01']")) WebElement cardMonth;
	@FindBy(xpath =("//*[text()='2023']")) WebElement cardYear;
	@FindBy(xpath = ("//input [@name='ppw-widgetEvent:AddCreditCardEvent']")) WebElement addCardButton;
	
	public pomPayment() {
		PageFactory.initElements(driver, this);
	}
	
	public void gotoAddPayment() {
		paymentsLink.click();
	}
	
	public void addCard() {
		addCardLink.click();
	}
	
	public void startAddingCard() {
		insertCardButton.click();
	}
	
	public void insertCardNumber (String num) {
		cardNum.sendKeys(num);
	}
	
	public void insertNameonCard(String name) {
		nameOnCard.sendKeys(name);
	}
	
	public void selectMonth(String month){
		cardMonth.click();
		driver.findElement(By.linkText(month)).click();

		//driver.findElement(By.linkText(month)).click();;
	}
	
	public void selectYear(String year) {
		cardYear.click();
		driver.findElement(By.linkText(year)).click();;
	}
	
	public void addCardButton() {
		addCardButton.click();
	}

}
