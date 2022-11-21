package pages;

import org.openqa.selenium.WebElement;

public class BasePage {

	protected void sendKeys(WebElement element, String text) throws InterruptedException {
		
		element.clear();
		element.sendKeys(text);
		Thread.sleep(200);
	}
	
	protected void click(WebElement element) throws InterruptedException {
		
		element.click();
		Thread.sleep(1000);
	}
}
