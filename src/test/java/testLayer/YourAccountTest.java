package testLayer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pomPackage.pomSignIn;
import testData.ExcelSheet;

public class YourAccountTest extends BaseAmazonClass{
	
	//public static Actions action;
	public static pomSignIn SignIn;
	public static String currentPage;
	
	public YourAccountTest () {
		super();
	}
	
	
	@BeforeMethod
	public void initialSetup() {
		initiation();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		hover();
		SignIn = new pomSignIn();
		SignIn.signInLink();
		SignIn.insertUsername(config.getProperty("username"));
		SignIn.continueButton();
		SignIn.insertPassword(config.getProperty("password"));
		SignIn.signinButton();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	
	@Test (priority = 1)
	public void VerifyAccountHover() {
		hover();
		System.out.println(SignIn.verifyYourAccountMenu());
	}
	
	@Test (priority = 2)
	public void VerifyAccountClick() {
		
		hover();
		SignIn.yourAccountLink();
		currentPage = driver.getCurrentUrl();
		Assert.assertEquals(currentPage, config.getProperty("YourAccountURL"));
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	

}
