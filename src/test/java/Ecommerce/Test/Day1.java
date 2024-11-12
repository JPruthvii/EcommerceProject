package Ecommerce.Test;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1 {
	@Test
	public void hoepage() throws InterruptedException
	{
		String item = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("userEmail")).sendKeys("jpmanoj1@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Passme@123");
		driver.findElement(By.id("login")).click();
		List<WebElement> products=	driver.findElements(By.cssSelector(".mb-3"));
		WebElement macthingProduct = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(item)).findFirst().orElse(null);
		macthingProduct.findElement(By.xpath("(//div[@class='card-body']/button)[2]")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait untill toast container is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// wait untill the blur screen is invisible
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#toast-container"))));


		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> productAdded = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean result = productAdded.stream().anyMatch(product->product.getText().equals(item));
		Assert.assertTrue(result);

		WebElement element = driver.findElement(By.cssSelector(".totalRow button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		Actions act=new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
		List<WebElement> suggestionCountry = driver.findElements(By.cssSelector(".ta-results button"));
		Optional<WebElement> country = suggestionCountry.stream().filter(suggestion->suggestion.getText().equalsIgnoreCase("india")).findFirst();
		if(country.isPresent())
		{
			country.get().click();
		}
		else
		{
			System.out.println("country is not found");
		}

		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();

		System.out.println(driver.findElement(By.cssSelector("td h1.hero-primary")).getText());


		Thread.sleep(2000);
		driver.quit();
	}

}

