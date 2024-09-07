package com.qa.baseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public WebDriver BaseSettings() {
		try {

			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\vivek\\eclipse-workspace\\Bigsmall_Hybrid\\src\\main\\java\\com\\qa\\config\\config.properties");

			prop.load(fis);

			String browserName = prop.getProperty("Browser");

			
			if (browserName.equalsIgnoreCase("Chrome")) {
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\vivek\\Documents\\chromedriver_win32\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

			else if (browserName.equalsIgnoreCase("Edge")) {
				//System.setProperty("webdriver.edge.driver", "C:\\Users\\vivek\\Documents\\edgedriver_win64\\msedgedriver.exe");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

			else if (browserName.equalsIgnoreCase("Firefox"))  { 
				//System.setProperty("webdriver.gecko.driver", "C:\\Users\\vivek\\Documents\\geckodriver-v0.30.0-win64\\geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

			    // Implicit wait to avoid element not found exception
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Maximize browser
				driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

}
