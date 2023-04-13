package testLayer;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseAmazonClass;
import pomPackage.pomPayment;
import pomPackage.pomSearch;
import pomPackage.pomSignIn;

public class SearchTest extends BaseAmazonClass{

	pomSignIn SignIn;
	pomSearch search;
	
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void initialization() {
		
		initiation();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//hover();
		//SignIn = new pomSignIn();
		search = new pomSearch();
		/*SignIn.signInLink();
		SignIn.insertUsername(config.getProperty("username"));
		SignIn.continueButton();
		SignIn.insertPassword(config.getProperty("password"));
		SignIn.signinButton();*/
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	/*@Test
	public void filterProducts() {
		search.inputProd(config.getProperty("SearchProduct"));
		search.search();
		search.filterByReview();
		driver.findElement(By.linkText(config.getProperty("ProductBrand"))).click();*/
		
	//}
	
	/*@Test
	public void sortProducts() throws InterruptedException {
		search.inputProd(config.getProperty("SearchProduct"));
		search.search();
		search.sortDropDown();
		driver.findElement(By.linkText(config.getProperty("ProductSort1"))).click();
		Thread.sleep(10000);
		search.sortDropDown();
		driver.findElement(By.linkText(config.getProperty("ProductSort2"))).click();
		Thread.sleep(5000);
		String item = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div[2]/div[1]/h2")).getText();
		System.out.println(item);
	    Boolean verify = item.contains(config.getProperty("SearchProduct"));
	    System.out.println(verify);
	}*/
	
	@Test (enabled = false)
	public void pagination() throws InterruptedException {
		
		search.inputProd(config.getProperty("SearchProduct"));
		search.search();
		Thread.sleep(5000);
		List <WebElement> pagination = driver.findElements(By.xpath("//div[@class= 'a-section a-text-center s-pagination-container']//a"));
		int s = pagination.size();
		System.out.println(s);
		WebDriverWait wait = new WebDriverWait (driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//* [text()='Next']")));
		WebElement next = driver.findElement(By.xpath("//* [text()='Next']"));
		//search.nextButton();
		
		
		for (int i=1; i<8; i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			search.nextButton();
		}
			
		}
		
			//String num = driver.findElement(By.xpath(".//span [contains (@class, 's-paginatiron-selected')]")).getText();
			//System.out.println("Page ended at " + num);
		
	@Test
	public void countProd () throws InterruptedException {
		search.inputProd(config.getProperty("SearchProduct"));
		search.search();
		Thread.sleep(5000);
		WebElement item = driver.findElement(By.xpath("//li [contains(b, 'ASIN:B091MBQYPH')]"));
		String att = item.getAttribute("data-asin");
		System.out.println(att);
	}
	

	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	
	}
}
