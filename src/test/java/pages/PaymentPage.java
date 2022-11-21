package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {
	
	@FindBy (id="cardNumber")
	WebElement cardNumber;

	@FindBy (id="expityMonth")
	WebElement expiryMonth;

	@FindBy (id="expityYear")
	WebElement expiryYear;

	@FindBy (id="cvCode")
	WebElement cvCode;

	@FindBy (xpath="//a[text()=\"Pay\"]")
	WebElement payBtn;
	
	
	public PaymentPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void pay(String cardnumber, String expirymonth, String expiryyear, String cvcode) throws InterruptedException {
	
		this.sendKeys(this.cardNumber, cardnumber);
		this.sendKeys(this.expiryMonth, expirymonth);
		this.sendKeys(this.expiryYear, expiryyear);
		this.sendKeys(this.cvCode, cvcode);
		
		this.click(this.payBtn);
		Thread.sleep(2000);
	}
}
