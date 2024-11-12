package Ecommerce.Test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ecommerce.TestingComponent.BaseTest;
import Ecommerce.pom.CartPage;
import Ecommerce.pom.ProductCatalogPage;

public class ErrorValidation extends BaseTest {
	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation() throws InterruptedException, IOException
	{
		homePage.goTo();
		ProductCatalogPage products=homePage.login("jpmanoj1@gmail.com","Passme@152345");
		String errorMessage=homePage.getErrorMessage();
		Assert.assertTrue(errorMessage.contains("Incorrect email or password."));
	}
	@Test
	public void productErrorValidation() throws InterruptedException, IOException

	{
		String item = "ZARA COAT 3";
		homePage.goTo();
		ProductCatalogPage products=homePage.login("jpmanoj1@gmail.com","Passme@123");
		CartPage cartPage=products.addToKart(item);
		boolean matching = cartPage.productISPresentOrNot("ZARA COAT 33");
		Assert.assertFalse(matching);

	}
}