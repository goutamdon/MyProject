package verificationCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidationCommands {

WebDriver driver=null;
	
	@BeforeTest
	public void setProperties() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium software\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
			
	}
	@Test
	public void m() {
		
		boolean status =driver.findElement(By.linkText("Forgotten account?")).isDisplayed();
		System.out.println(status);
		
	}
	@AfterTest
	public void closeWindow() {
		driver.quit();
	}

	
	
}
