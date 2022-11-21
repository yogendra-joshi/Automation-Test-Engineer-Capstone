package test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	protected static WebDriver driver;
	
	@BeforeMethod
	public void SetUp(Method method) {
			
		// Register the driver for chrome
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");		
		driver = new ChromeDriver();
		driver.get("http://localhost:8082/medicare/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		PageFactory.initElements(driver, this);
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.quit();		
	}
}
