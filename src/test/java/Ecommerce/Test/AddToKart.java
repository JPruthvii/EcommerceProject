package Ecommerce.Test;

import org.testng.annotations.Test;

import Ecommerce.TestingComponent.BaseTest;
import Ecommerce.pom.CartPage;
import Ecommerce.pom.CheckOutPage;
import Ecommerce.pom.MyOrdersPage;
import Ecommerce.pom.OrderHistoryPage;
import Ecommerce.pom.ProductCatalogPage;

import java.io.IOException;

import org.testng.Assert;

public class AddToKart extends BaseTest{
	String item = "ZARA COAT 3";
	String country = "India";
	@Test
	public void submitOrder() throws InterruptedException, IOException
	{
		
		String confirmationMessage="THANKYOU FOR THE ORDER.";
		ProductCatalogPage products=homePage.login("jpmanoj1@gmail.com","Passme@123");
		CartPage cart=products.addToKart(item);
		Assert.assertTrue(cart.checkOut(item));
		CheckOutPage check=new CheckOutPage(driver);
		OrderHistoryPage order=check.checkOut(country);
		String message = order.getConfirmation();
		System.out.println(message);
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(message));

	}
	@Test(dependsOnMethods = {"submitOrder"})
	public void ordersPageValidation() throws InterruptedException
	{
		ProductCatalogPage products=homePage.login("learner@gmail.com","Passme@123");
		MyOrdersPage myOrderpage = products.goToOrderHeader();
		boolean result = myOrderpage.productISPresentOrNot(item);
		Assert.assertTrue(result, item);
		
	}
	
}



