package testLayer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pomPackage.pomSignIn;
import pomPackage.pomYourAddress;
import pomPackage.pomYourOrders;
import testData.ExcelSheet;

public class YourAddressTest extends BaseAmazonClass{
	
	pomSignIn SignIn;
	pomYourAddress address;
	Actions action;
	
	
	public YourAddressTest() {
		super();
	}
	
	@BeforeMethod
	public void initialization() {
		initiation();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		hover();
		SignIn = new pomSignIn();
		address = new pomYourAddress();
		SignIn.signInLink();
		SignIn.insertUsername(config.getProperty("username"));
		SignIn.continueButton();
		SignIn.insertPassword(config.getProperty("password"));
		SignIn.signinButton();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	@DataProvider
	public Object [][] inputs(){
		Object data[][] = ExcelSheet.readinput("Address");
		return data;
	}
	
	
	@Test (dataProvider = "inputs")
	public void addAddress(String name, String pn, String addy, String city, String prov, String pc) {
		hover();
		SignIn.AccountListLink();
		address.AddressModule();
		address.addAddressLink();

		//address.countryDD();
		//driver.findElement(By.linkText("Canada")).click();
	
		address.insertFullName(name);
		address.insertPhoneNum(pn);
		address.insertAddressField(addy);
		address.insertCity(city);
		address.selectProvince();
		driver.findElement(By.linkText(prov)).click();
		address.insertPostalcode(pc);
		address.clickaddAddressbutton();
		driver.getPageSource().contains("Address saved");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}

}
