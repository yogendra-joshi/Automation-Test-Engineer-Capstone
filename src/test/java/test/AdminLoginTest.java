package test;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageProductsPage;
import pages.ViewProductsPage;

public class AdminLoginTest extends BaseClass{

	@Test
	public void addProduct() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("vk@gmail.com", "admin");		
		HomePage homePage = new HomePage(driver);
		homePage.manageProducts();
		
		ManageProductsPage manageProducts = new ManageProductsPage(driver);
		String name = "Testing Med - 2";
		manageProducts.addProduct(name, "Royal", "Test medicine", "15", "50", 
				"C:\\PROTECH\\SimpliLearn-Course\\eclips_workspace\\capstone\\TestMedicine.jpg", 
				"Antibiotics");		
		// click on view product
		homePage.viewProducts();
		String[] expMedicine = {name};
		ViewProductsPage viewProducts = new ViewProductsPage(driver);	
		viewProducts.productsByFilter(name, expMedicine);		
		homePage.Logout();
	}
}
