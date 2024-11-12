package Ecommerce.AbstractComponent;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ecommerce.pom.MyOrdersPage;

public class AbstractComponent {


	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css=".cartSection h3")
	WebElement productsAddedToKart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartTab;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderTab;
	
	public void visiblityOfELementByLocator(By findBy)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void invisiblityOfELementByLocator(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void visiblityOfELement(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}


	public void goToKartPage()
	{
		cartTab.click();
	}
	
	public MyOrdersPage goToOrderHeader()
	{
		orderTab.click();
		MyOrdersPage myOrder= new MyOrdersPage(driver);
		return myOrder;
		
	}
	
	public void scrollBy(WebElement ele) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(1000);
	}
}
