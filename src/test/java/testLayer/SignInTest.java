package testLayer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pomPackage.pomSignIn;
import testData.ExcelSheet;

public class SignInTest extends BaseAmazonClass {
	
	pomSignIn SignIn;
	Actions action;
	String currentPage;
	
	
	public SignInTest() {
		
		super();
	}
	
	/*@BeforeTest
	public void init() {
		initiation();*/
		
	//}
	
	
	@BeforeMethod
	public void initialSetup() {
		initiation();
		SignIn = new pomSignIn();
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

		
		
	}
	
	@DataProvider
	public Object[][] Inputs(){
		Object data[][]=ExcelSheet.readinput("Sign Details");
		return data;
	}
	
	@Test (priority = 1, dataProvider = "Inputs")
	public void validSignIn(String UN, String pass, String name) {
		
		SignIn.signInLink();
	SignIn.insertUsername(UN);
	SignIn.continueButton();
	SignIn.insertPassword(pass);
	SignIn.signinButton();
	String actual = SignIn.verifySignIn();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Assert.assertEquals(actual, "Hello, "+ name);
	
	}
	/*
	@Test (priority = 2)
	public void myAccount() {
		
		SignIn.verifyYourAccountMenu();
	}
	
	@Test (priority = 3)
	public void myAccountClick() {
		
		SignIn.yourAccountLink();
		currentPage = driver.getCurrentUrl();
		Assert.assertEquals(currentPage, "https://www.amazon.ca/gp/css/homepage.html?ref_=nav_ya_signin");
	}*/
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}

//action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		//driver.findElement(By.linkText("Sign in")).click();