package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	

	@FindBy(id = "dropdownMenu1")
	WebElement UserNameBtn;

	@FindBy(id = "logout")
	WebElement LogoutLink;
	
	@FindBy (xpath="//div[@class='alert alert-success']")
	WebElement LogoutMessage;
	
	@FindBy(xpath = "//a[text()=\"View Products\"]")
	WebElement ViewProducts;
	
	@FindBy(xpath = "//a[text()=\"Manage Product\"]")
	WebElement ManageProduct;
	
	WebDriver driver;
		
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void productsByCategory(String category, String[] expectedMedicine) {
		
		this.driver.findElement(By.xpath("//a[text()=\"" + category + "\"]")).click();
		List<WebElement> MedicineList = this.driver.findElements(By.xpath("//tr//td[2]"));
		
		Integer index = 0;		
		for (WebElement medicine:MedicineList) {
			
			Assert.assertEquals(medicine.getText(), expectedMedicine[index]);
			index++;
		}
	}
	
	public void Logout() throws InterruptedException {
		
		this.UserNameBtn.click();
		this.LogoutLink.click();
		Thread.sleep(100);
		
		Assert.assertEquals(this.LogoutMessage.getText(), "You have logged out successfully!");
		Thread.sleep(2000);
	}
	
	public void viewProducts() throws InterruptedException {
		
		this.ViewProducts.click();
		Thread.sleep(500);
	}
	
	public void manageProducts() throws InterruptedException {
		
		this.ManageProduct.click();
		Thread.sleep(500);
	}
}
