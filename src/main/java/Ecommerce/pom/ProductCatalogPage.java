package Ecommerce.pom;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponent.AbstractComponent;


public class ProductCatalogPage extends AbstractComponent{
	WebDriver driver;

	public ProductCatalogPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> products;

	@FindBy(css=".ng-animating")
	WebElement pageLoader;

	By productkey=By.cssSelector(".mb-3");
	By addToKartButton=By.xpath("(//div[@class='card-body']/button)[2]");
	By toastCOntainer=By.cssSelector("#toast-container");


	public List<WebElement> productList()
	{
		visiblityOfELementByLocator(productkey);
		return products;
	}


	public WebElement productByName(String item)
	{
		WebElement macthingProduct = products.stream().filter(product->product.
				findElement(By.cssSelector("b")).
				getText().equals(item)).findFirst().orElse(null);
		return macthingProduct;
	}

	public CartPage addToKart(String item) throws InterruptedException
	{
		WebElement productname = productByName(item);
		productname.findElement(addToKartButton).click();
		visiblityOfELementByLocator(toastCOntainer);
		Thread.sleep(1000);
		//invisiblityOfELementByLocator(pageLoader);
		goToKartPage();
		return new CartPage(driver);
	}
	
	public void goToOrderPage()
	{
		goToOrderHeader();
	}









}
