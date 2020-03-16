package mobileScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LaunchApp {

	@Test
	public void launchApp() throws MalformedURLException {
		
		// /
	
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("deviceName", "a8d92e88");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("platformName", "Android");
		dc.setCapability("appPackage", "com.whatsapp");
		dc.setCapability("appActivity", "com.whatsapp.HomeActivity");

		dc.setCapability("fullReset", false);
		dc.setCapability("noReset", true);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);

	}
}
