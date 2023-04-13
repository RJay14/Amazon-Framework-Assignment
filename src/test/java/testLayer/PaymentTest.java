package testLayer;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import basePackage.BaseAmazonClass;
import pomPackage.pomPayment;
import pomPackage.pomSignIn;
import pomPackage.pomYourAddress;
import testData.ExcelSheet;

public class PaymentTest extends BaseAmazonClass{
	
	pomSignIn SignIn;
	pomPayment payment;
	
	public PaymentTest() {
		
	super();
	}
	
	@BeforeMethod
	public void initialization() {
		
		initiation();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		hover();
		SignIn = new pomSignIn();
		payment = new pomPayment();
		SignIn.signInLink();
		SignIn.insertUsername(config.getProperty("username"));
		SignIn.continueButton();
		SignIn.insertPassword(config.getProperty("password"));
		SignIn.signinButton();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	
	@DataProvider
	public Object[][] cardDetails(){
		Object cards[][]=ExcelSheet.readinput("Card Details");
		return cards;
	}
	
	@Test (dataProvider = "cardDetails")
	public void addCardTest(String num, String name, String month, String year) throws InterruptedException {
		
		SignIn.AccountListLink();
		payment.gotoAddPayment();
		payment.addCard();
		payment.startAddingCard();
		
		
		driver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("addCreditCardNumber")));
		payment.insertCardNumber(num);
		Thread.sleep(10000);
		payment.insertNameonCard(name);
		Thread.sleep(10000);
		payment.selectMonth(month);
		payment.selectYear(year);
		driver.findElement(By.xpath("//input [@name='ppw-widgetEvent:AddCreditCardEvent']")).click();
	    
	}
	
	@AfterMethod
	public void close () throws InterruptedException {
		Thread.sleep(1500);
		driver.close();
	}
	

}
