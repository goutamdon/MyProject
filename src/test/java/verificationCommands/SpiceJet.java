package verificationCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpiceJet {
WebDriver driver=null;
	
	@BeforeTest
	public void setProperties() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium software\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.spicejet.com/");
			
	}
	@Test
	public void m() {
		boolean radioButton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected();
		System.out.println("One way search "+radioButton);
		boolean status =driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled();
		System.out.println("datepicker" +status);
		
	}
	@AfterTest
	public void closeWindow() {
		driver.quit();
	}


}
