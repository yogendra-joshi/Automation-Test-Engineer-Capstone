package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConfirmationPage extends BasePage{

	@FindBy (xpath = "//div[@class=\"alert alert-success\"]/h3")
	WebElement message;
	
	@FindBy (xpath = "//a[text()=\"Medicare\"]")
	WebElement homeBtn;
	
	
	public OrderConfirmationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void verify() {
		
		Assert.assertEquals(message.getText(), "Your Order is Confirmed!!");
	}
	
	public void goToHome() throws InterruptedException {
		
		this.click(this.homeBtn);
	}
}
