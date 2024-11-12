package Ecommerce.TestingComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Ecommerce.pom.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public HomePage homePage;
	
	public void intililizeDriver() throws IOException
	{
		Properties prop=new Properties();
		///RahulShetty/src/main/java/Ecommerce/Resources/GlobalData.properties
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Ecommerce\\Resources\\GlobalData.properties");
	//	FileInputStream fis=new FileInputStream(".\\src\\main\\java\\Ecommerce\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
          
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	//we are using the before method because we are inherting the this class property in the ADDTOKart class so it will check for the ADDTOKart
	@BeforeMethod(alwaysRun = true)
	public void LaunchingApplication() throws IOException
	{
		intililizeDriver();
		homePage = new HomePage(driver);
		homePage.goTo();

	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException
	{
		driver.quit();
	}
	
	public String getScreenShoot(String tasteCaseName) throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		File des= new File(System.getProperty("user.dir")+"//ScreenShoot//"+tasteCaseName+".png");
		FileUtils.copyFile(file, des);
		return System.getProperty("user.dir")+"//ScreenShoot//"+tasteCaseName+".png";
		
	}
}
