package pomPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseAmazonClass;

public class pomSignIn extends BaseAmazonClass{

	@FindBy(id="ap_email") WebElement username;
	@FindBy(id="ap_password") WebElement password;
	@FindBy(id="continue") WebElement continueBtn;
	@FindBy(id="signInSubmit") WebElement SignInBtn;
	@FindBy(id="nav-link-accountList-nav-line-1") WebElement myAccount;
	@FindBy(id="nav-al-container") WebElement yourAccountMenu;
	@FindBy(linkText="Sign in") WebElement signInLink;
	@FindBy(linkText="Your Account") WebElement yourAccountLink;
	@FindBy(id = "nav-link-accountList")WebElement AccountList;
	
	
	public pomSignIn() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void insertUsername(String name) {
		
		username.sendKeys(name);
	}
	
	public void insertPassword(String pass) {
		
		password.sendKeys(pass);
	}
	
	public void continueButton() {
		
		continueBtn.click();
	}
	
	public void signinButton() {
		
		SignInBtn.click();
	}
	
	public void signInLink() {
		
		signInLink.click();
	}
	
	public void yourAccountLink() {
		
		yourAccountLink.click();
	}
	
	
	public String verifySignIn() {
		
		return myAccount.getText();
	}
	
	public boolean verifyYourAccountMenu() {
		return yourAccountMenu.isDisplayed();
		}
	public void AccountListLink() {
		AccountList.click();
	}
}
