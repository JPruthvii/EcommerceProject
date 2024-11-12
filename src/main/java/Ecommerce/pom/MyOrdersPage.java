package Ecommerce.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import Ecommerce.AbstractComponent.AbstractComponent;
public class MyOrdersPage extends AbstractComponent{

	 WebDriver driver;
	 
	 @FindBy(css="tr td:nth-child(3)")
	 List<WebElement> listOfProductInMyOrder;
	 
	 
	public MyOrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public boolean productISPresentOrNot(String item) throws InterruptedException
	{
		boolean result = listOfProductInMyOrder.stream().anyMatch(product->product.getText().equals(item));
		return result;
	}
	
	
}
