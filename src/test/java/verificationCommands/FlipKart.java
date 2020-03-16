package verificationCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipKart {
	
	WebDriver driver = null;
	@BeforeTest
	public void systemProperties() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	
	@Test
	public void flipKart() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		Actions action =new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(6000);		
		//scroll down
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		//scroll Up
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
