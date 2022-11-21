package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "login")
	WebElement LoginLink;

	@FindBy(id = "username")
	WebElement UserName;

	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement LoginBtn;

	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}	
	
	public void Login(String username, String password) throws InterruptedException {
		
		this.LoginLink.click();
		Thread.sleep(2000);
		
		this.UserName.sendKeys(username);
		this.Password.sendKeys(password);
		this.LoginBtn.click();		
		Thread.sleep(2000);
	}
	
}
