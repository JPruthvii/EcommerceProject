package Ecommerce.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Ecommerce.AbstractComponent.AbstractComponent;


public class OrderHistoryPage extends AbstractComponent{
	WebDriver driver;

	public OrderHistoryPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="td h1.hero-primary")
	WebElement confirmationMsg;
	
	public String getConfirmation()
	{
		String successMsg=confirmationMsg.getText();
		return successMsg;
	}

}
