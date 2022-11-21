package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ViewProductsPage {

	@FindBy (xpath="//input[@type=\"search\"]")
	WebElement searchBox;
	
	@FindBy (xpath="//tr//td[2]")
	List<WebElement> MedicineList;

	@FindBy (xpath="//tr//td[6]/a[2]")
	WebElement cartBtn;
	
	WebDriver driver;
	
	public ViewProductsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void productsByFilter(String filterText, String[] expectedMedicine) throws InterruptedException {
		
		this.sendKeys(this.searchBox, filterText);
		// Assert.assertEquals(expectedMedicine.length, MedicineList.size());
		
		Integer index = 0;
		for (WebElement medicine:MedicineList) {
			
			Assert.assertEquals(medicine.getText(), expectedMedicine[index]);
			index++;
			if (index >= expectedMedicine.length) {
				break;
			}
		}
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		
		this.sendKeys(this.searchBox, productName);
		Assert.assertEquals(MedicineList.get(0).getText(), productName);
		this.cartBtn.click();
	}
	
	private void sendKeys(WebElement element, String text) throws InterruptedException {
		
		element.clear();
		element.sendKeys(text);
		Thread.sleep(200);
	}
}
