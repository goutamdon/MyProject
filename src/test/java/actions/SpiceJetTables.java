package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpiceJetTables {
	WebDriver driver = null;
	@BeforeTest
	public void setProperties() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium software\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.spicejet.com/");
			
	}
	@Test
	public void m() throws InterruptedException {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Ahmedabad (AMD)")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Ajmer (KQH)")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_Adult\"]"))).selectByVisibleText("3");
		Thread.sleep(3000);
		new Select(driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"))).selectByVisibleText("INR");
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		Thread.sleep(3000);
		
	}
	@AfterTest
	public void closeWindow() {
		driver.quit();
		}
}