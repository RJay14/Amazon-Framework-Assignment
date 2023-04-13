package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;

public class pomSearch extends BaseAmazonClass{

	@FindBy (id = "twotabsearchtextbox") WebElement searchBox;
	@FindBy (id = "nav-search-submit-button") WebElement searchButton;
	@FindBy (xpath = "//*[@id=\"p_72/11192170011\"]/span/a/section/i") WebElement reviewFilter;
	@FindBy (className = "a-dropdown-label") WebElement sortDD;
	@FindBy (xpath = "//* [text()='Next']") WebElement nextButton;
	
	public pomSearch() {
		PageFactory.initElements(driver, this);
	}
	
	public void inputProd(String prod) {
		searchBox.sendKeys(prod);
	}
	
	public void search () {
		searchButton.click();
	}
	
	public void filterByReview() {
		reviewFilter.click();
	}
	
	public void sortDropDown() {
		sortDD.click();
	}
	
	public void nextButton() {
		nextButton.click();
	}
	
}
