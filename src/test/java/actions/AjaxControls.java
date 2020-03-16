package actions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AjaxControls {
	
	Logger log = Logger.getLogger(AjaxControls.class);
	//https://jqueryui.com/
		WebDriver driver=null;
		@BeforeTest
		public void setProperties() {
			try {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium software\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get("https://www.google.com/");
				log.info("successfully login");
			}catch(Exception e) {
				log.fatal("Browser is not launching");
			}
		}
		@Test
		public void m() throws InterruptedException {
			try {
			driver.findElement(By.name("q")).sendKeys("selenium");
			Thread.sleep(5000);
			log.info("send the value to text box");
			}catch(Exception e) {
				log.error("element not found");
			}
			String text = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[2]/div[2]")).getText();
			//System.out.println(text);
			String[] s = text.split("\n");
			//System.out.println(s[2]);
		
			for(int i=0;i<s.length;i++) {
				if(s[i].equals("selenium webdriver")) {
					driver.findElement(By.name("q")).clear();
					Thread.sleep(3000);
					driver.findElement(By.name("q")).sendKeys(s[i]);
					Thread.sleep(3000);
					driver.findElement(By.name("btnK")).click();
				}
			}
		}
		@AfterTest
		public void closeWindow() {
			driver.quit();
		}
}
