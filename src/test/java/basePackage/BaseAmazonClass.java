package basePackage;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class BaseAmazonClass {
	
	public static Properties config = new Properties ();
	public static WebDriver driver;
	public static Actions action;
	
	
	
	public BaseAmazonClass() {
		
		try {
		
		FileInputStream file = new FileInputStream ("C:\\Users\\rajit\\eclipse-workspace\\AmazonProject\\src\\test\\java\\environmentVariables\\Config.properties");
		config.load(file);
	}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException a) {
			a.printStackTrace();
		}
		
	}
	
	public static void initiation() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(config.getProperty("url"));
		
	}
	public static void hover() {
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
	}
	
	
}
