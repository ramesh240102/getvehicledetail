package com.govdvla.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {
	
	private static WebDriver driver;
	
	public static WebDriver getDriverInstance() throws IOException
	{
		
				
		String browser = "Chrome";

		if ((browser.equals("Chrome")) && (driver==null))
		{
			//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			//capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			System.setProperty("webdriver.chrome.driver", "c://Tools//chromedriver.exe");
			
			driver=new ChromeDriver();

		}	
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();


		return driver;
	}

}
