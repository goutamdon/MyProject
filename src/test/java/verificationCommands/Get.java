package verificationCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Get {
	WebDriver driver=null;
	
	@BeforeTest
	public void setProperties() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium software\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
			
	}
	@Test(enabled = false)
	public void m() {
		String title = driver.getTitle();
		System.out.println("Actual title"+title);
		if(title.contains("Facebook")) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
	}
	@Test(priority = 0)
	public void validationCommands() throws InterruptedException {
		String url = driver.getCurrentUrl();
		System.out.println("Actual url"+url);
		if(url.equals("https://www.facebook.com/")) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
		String text = driver.findElement(By.xpath("//a[text()='Instagram']")).getText();
		//System.out.println(text);
		boolean status  =text.equalsIgnoreCase("instagram");
		System.out.println(status);
	}
	@Test(priority = 1)
	public void pageSource() {
		String pageSource = driver.getPageSource();
		//System.out.println(pageSource);
		if(pageSource.contains("What's your name?"))
		{
			System.out.println("test failed");
		}else {
			System.out.println("test passed");
		}
		driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]")).click();//submit 
		String pageSource1 = driver.getPageSource();
		
		if(pageSource1.contains("What's your name?"))
		{
			System.out.println("test passed for after submit click");
		}else {
			System.out.println("test failed for after click submit button");
		}		
	}
	@AfterTest
	public void closeWindow() {
		driver.quit();
	}

}
