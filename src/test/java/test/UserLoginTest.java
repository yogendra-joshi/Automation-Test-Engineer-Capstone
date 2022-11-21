package test;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.PaymentPage;
import pages.SelectAddressPage;
import pages.ViewProductsPage;

public class UserLoginTest extends BaseClass{
	
	@Test
	public void CategoryTest() throws InterruptedException {
		
		// Check for the category medicine
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("kn@gmail.com", "12345");
		
		HomePage homePage = new HomePage(driver);
		String[] expectedMedicine = {"Paracetamol", "Combiflame"};		
		homePage.productsByCategory("Antipyretics", expectedMedicine);
		homePage.Logout();		
	}
	
	@Test
	public void ProductFilterTest() throws InterruptedException {
		
		// Find for the Amoxicillin medicine
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("kn@gmail.com", "12345");
		
		HomePage homePage = new HomePage(driver);
		homePage.viewProducts();
		
		ViewProductsPage viewProducts = new ViewProductsPage(driver);				
		String[] expectedMedicine = {"Amoxicillin"};	
		viewProducts.productsByFilter("Amox", expectedMedicine);
		
		homePage.Logout();			
	}
	
	@Test
	public void BuyMedicineTest() throws InterruptedException {
		
		// Buy 2 Paracetamol medicine
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("kn@gmail.com", "12345");

		HomePage homePage = new HomePage(driver);
		homePage.viewProducts();
		
		ViewProductsPage viewProductPage = new ViewProductsPage(driver);
		viewProductPage.addProductToCart("Paracetamol");
		
		CartPage cartPage = new CartPage(driver);
		cartPage.checkOut("2");
		
		SelectAddressPage selectAddressPage = new SelectAddressPage(driver);
		selectAddressPage.selectExistingAddress();
		
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.pay("1234567890", "10", "2022", "34");
		
		OrderConfirmationPage orderConfirmPage = new OrderConfirmationPage(driver);
		orderConfirmPage.verify();
		orderConfirmPage.goToHome();
		
		homePage.Logout();		
	}
}
