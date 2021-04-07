package com.qa.crmpro.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.crmpro.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * 
 * @author User
 *
 */
public class BasePage {

	/**
	 * this method is used to initialize the WebDriver on the basis of browser
	 * @param browserName
	 * @return driver
	 */
	protected static WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	
	/**
	 * this method is used to initialize the properties from config.properties file
	 * @return prop
	 */
	public Properties inti_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(".\\src\\main\\java\\com\\qa\\crmpro\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
	
	
	
	
}
