package testLayer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pomPackage.pomCart;
import pomPackage.pomSearch;

public class CartTest extends BaseAmazonClass{
	 
	pomSearch search;
	pomCart cart;

	public CartTest() {
		super();
	}
	@BeforeMethod
	public void initialization() {
		initiation();
		search = new pomSearch();
		cart = new pomCart();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void shoppingCart() throws InterruptedException {
		search.inputProd(config.getProperty("SearchProduct"));
		search.search();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//* [text()= 'WILSON NBA Authentic Series Basketballs']")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		WebElement sizeDD = driver.findElement(By.id("native_dropdown_selected_size_name"));
		Select size = new Select(sizeDD);
		size.selectByValue("1,B091MGGWJW");
		Thread.sleep(5000);
		//System.out.println("price: " + driver.findElement(By.xpath("//*[@class=\"corePrice_feature_div\"]/div/span/span[1]")).getText());
		WebElement addBtn = driver.findElement(By.id("add-to-cart-button"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		cart.clickAddtoCartBtn();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		cart.gotoCart();
		//wait.until(ExpectedConditions.elementToBeClickable(proceed));
		System.out.println("sub: " + driver.findElement(By.id("sc-subtotal-amount-buybox")).getText());
		//driver.findElement(By.xpath("//input [text() = 'Proceed to Checkout']")).click();
		if (driver.findElement(By.id("sc-subtotal-amount-buybox")).getText() != "$0.00"){
			System.out.println("Price is not $0");
		}
		else {
			System.out.println("price updated");
		}
	}
	
	@Test (priority = 2)
	public void updateCount () throws InterruptedException {
		search.inputProd(config.getProperty("SearchProduct"));
		search.search();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//* [text()= 'WILSON NBA Authentic Series Basketballs']")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		WebElement sizeDD = driver.findElement(By.id("native_dropdown_selected_size_name"));
		Select size = new Select(sizeDD);
		size.selectByValue("1,B091MGGWJW");
		Thread.sleep(5000);
		WebElement addBtn = driver.findElement(By.id("add-to-cart-button"));
		addBtn.click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement proceed = driver.findElement(By.id("nav-cart"));
		//wait.until(ExpectedConditions.elementToBeClickable(proceed));
		proceed.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		cart.updateQuantity();
		Thread.sleep(5000);
	
		
	}
	
	@AfterMethod
	public void closebrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
}
