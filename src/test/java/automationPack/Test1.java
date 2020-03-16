package automationPack;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	
WebDriver driver = null;
	
	@BeforeTest
	public void setProperties() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium software\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void fbWindowHandle() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Instagram']")).click();
		Set<String> allWindows = driver.getWindowHandles();	
		Object[] window = allWindows.toArray();
		driver.switchTo().window(window[2].toString());
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("9908139161");
		driver.switchTo().window(mainWindow);
		//driver.switchTo().window(window[0].toString());
		driver.close();
		Thread.sleep(4000);
	}
	@AfterTest
	public void closeWindow() {
		driver.quit();
	}
}
