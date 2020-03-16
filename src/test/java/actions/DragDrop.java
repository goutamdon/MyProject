package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragDrop {

	WebDriver driver=null;
	@BeforeTest
	public void setProperties() {
		/*
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium software\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			*/
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium software\\chromedriver.exe");
			driver = new ChromeDriver();
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://jqueryui.com/droppable/");
	}
	@Test
	public void m() throws InterruptedException {
		
		//WebElement frame = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		driver.switchTo().frame(0);	
		WebElement src =  driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}
	@AfterTest
	public void closeWindow() {
		driver.quit();
	}

}
