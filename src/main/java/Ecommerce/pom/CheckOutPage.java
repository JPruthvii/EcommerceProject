package Ecommerce.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Ecommerce.AbstractComponent.AbstractComponent;


public class CheckOutPage extends AbstractComponent {
	WebDriver driver;

	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	By countrySuggestionDropDown=By.cssSelector(".ta-results.list-group.ng-star-inserted");


	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	@FindBy(css=".ta-results button")
	List<WebElement> ListOfSuggestion;
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement placeOrderButton;

	public OrderHistoryPage checkOut(String countryName) { 
		Actions act=new
				Actions(driver); act.sendKeys(country, countryName).build().perform();
				visiblityOfELementByLocator(countrySuggestionDropDown);
				selectCountry(countryName);
				placeOrderButton.click();
				return new OrderHistoryPage(driver);

	}
	public void selectCountry(String countryName)
	{
		WebElement matchingCountry=ListOfSuggestion.stream().filter(suggestion->suggestion.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
		matchingCountry.click();

	}
}


