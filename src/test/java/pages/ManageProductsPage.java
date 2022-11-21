package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageProductsPage {
	
	@FindBy(id="name")
	WebElement name;

	@FindBy(id="brand")
	WebElement brand;

	@FindBy(id="description")
	WebElement description;

	@FindBy(id="unitPrice")
	WebElement unitPrice;

	@FindBy(id="quantity")
	WebElement quantity;
	
	@FindBy(id="file")
	WebElement file;

	@FindBy(id="categoryId")
	WebElement categoryId;

	@FindBy(name="submit")
	WebElement submitBtn;
	
	public ManageProductsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void addProduct(String name, String brand, String description, String unitprice,
			String quantity, String filepath, String categoryid) throws InterruptedException {
	
		this.sendKeys(this.name, name);
		this.sendKeys(this.brand, brand);
		this.sendKeys(this.description, description);
		this.sendKeys(this.unitPrice, unitprice);
		this.sendKeys(this.quantity, quantity);
		this.sendKeys(this.file, filepath);
		
		Select category = new Select(this.categoryId);
		category.selectByVisibleText(categoryid);
		
		Thread.sleep(2000);
		submitBtn.click();
	}
	
	private void sendKeys(WebElement element, String data) {
		
		element.clear();
		element.sendKeys(data);
	}
}
