package Ecommerce.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	public void login(String username,String pass)
	{
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}
}
