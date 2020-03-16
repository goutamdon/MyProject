package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHover {	
	
	//https://jqueryui.com/
	WebDriver driver=null;
	@BeforeTest
	public void setProperties() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium software\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.amazon.com/");
	}
	@Test
	public void m() throws InterruptedException {
		WebElement e =  driver.findElement(By.xpath("(//*[text()='Account & Lists'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(e).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Find a Gift']")).click();
	}
	@AfterTest
	public void closeWindow() {
		driver.quit();
	}
}