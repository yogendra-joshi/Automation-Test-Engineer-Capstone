package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectAddressPage extends BasePage {
	
	@FindBy (xpath="//a[text()=\"Select\"]")
	WebElement selectBtn;
	
	public SelectAddressPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void selectExistingAddress() throws InterruptedException {
		
		this.click(this.selectBtn);
	}
}
