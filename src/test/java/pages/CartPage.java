package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

	
	WebDriver driver;
	
	@FindBy (xpath="//td[@data-th=\"Quantity\"]/input")
	WebElement quantity;
	
	@FindBy (xpath="//a[text()=\"Checkout \"]")
	WebElement checkout;
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkOut(String quantity) throws InterruptedException {
		
		this.sendKeys(this.quantity, quantity);
		this.click(this.checkout);
	}
}
