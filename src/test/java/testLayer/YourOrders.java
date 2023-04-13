package testLayer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pomPackage.pomSignIn;
import pomPackage.pomYourOrders;

public class YourOrders extends BaseAmazonClass{
	
	pomSignIn SignIn;
	pomYourOrders yourOrder;
	Actions action;
	
public YourOrders() {
	super();
}

@BeforeMethod
public void initialize() {
	initiation();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	hover();
	SignIn = new pomSignIn();
	yourOrder = new pomYourOrders();
	SignIn.signInLink();
	SignIn.insertUsername(config.getProperty("username"));
	SignIn.continueButton();
	SignIn.insertPassword(config.getProperty("password"));
	SignIn.signinButton();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	
}

@Test (priority = 1)
public void YourOrdersHover() {
	hover();
	SignIn.AccountListLink();
	yourOrder.YourOrdersButton();
	Assert.assertEquals(driver.getTitle(), "Your Orders");
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	yourOrder.Yourorderdropdown();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.findElement(By.linkText("2023")).click();
	yourOrder.Yourorderdropdown();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	driver.findElement(By.linkText("past 3 months")).click();
	yourOrder.Yourorderdropdown();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	driver.findElement(By.linkText("the past 30 days")).click();
	
	
}

@Test (priority = 2)
public void BuyAgain() {
	hover();
	SignIn.AccountListLink();
	yourOrder.YourOrdersButton();
	yourOrder.BuyAgain();
}

@Test (priority = 3)
public void modules() {
	hover();
	SignIn.AccountListLink();
	yourOrder.YourOrdersButton();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	yourOrder.BuyAgain();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	yourOrder.CancelledLink();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	yourOrder.NotShipped();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
}

@AfterMethod
public void close() throws InterruptedException {
	Thread.sleep(4000);
	driver.close();
}

}
