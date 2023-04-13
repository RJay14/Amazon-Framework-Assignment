package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;

public class pomYourAddress extends BaseAmazonClass{

	@FindBy(css = "#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a > div") WebElement addressMod;
	@FindBy(linkText = "Add Address") WebElement addAddressLink;
	@FindBy(css = "#address-ui-widgets-countryCode > span > span") WebElement countryDD;
	@FindBy(id = "address-ui-widgets-enterAddressFullName") WebElement fullName;
	@FindBy(id = "address-ui-widgets-enterAddressPhoneNumber") WebElement phoneNum;
	@FindBy(id = "address-ui-widgets-enterAddressLine1") WebElement addressField;
	@FindBy(id = "address-ui-widgets-enterAddressCity") WebElement City;
	@FindBy(id = "address-ui-widgets-enterAddressPostalCode") WebElement postalcode;
	@FindBy(css = "#address-ui-widgets-enterAddressStateOrRegion > span > span") WebElement provDD;
	@FindBy(css = "#address-ui-widgets-form-submit-button") WebElement AddAddressButton;


public pomYourAddress() {
	PageFactory.initElements(driver, this);
}

public void AddressModule() {
	addressMod.click();
}

public void addAddressLink() {
	addAddressLink.click();
}

public void countryDD() {
	countryDD.click();
}

public void insertFullName(String name) {
	fullName.sendKeys(name);
}

public void insertPhoneNum(String phonenumber) {
	phoneNum.sendKeys(phonenumber);
}

public void insertAddressField(String addy) {
	addressField.sendKeys(addy);
}
public void insertCity(String city) {
	City.sendKeys(city);
}

public void insertPostalcode(String pc) {
	postalcode.sendKeys(pc);
}

public void selectProvince() {
	provDD.click();
}

public void clickaddAddressbutton() {
	AddAddressButton.click();
}


}


