package Ecommerce.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import Ecommerce.AbstractComponent.AbstractComponent;
public class CartPage extends AbstractComponent{

	 WebDriver driver;
	 
	 @FindBy(css=".cartSection h3")
	 List<WebElement> listOfProductInKart;
	 @FindBy(css=".totalRow button")
	 WebElement checkOutButton;

	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public boolean checkOut(String item) throws InterruptedException
	{
		boolean result = listOfProductInKart.stream().anyMatch(product->product.getText().equals(item));
		scrollBy(checkOutButton);
		checkOutButton.click();
		return result;
	}
	public boolean productISPresentOrNot(String item) throws InterruptedException
	{
		boolean result = listOfProductInKart.stream().anyMatch(product->product.getText().equals(item));
		scrollBy(checkOutButton);
		return result;
	}
	
	
}
