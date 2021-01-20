package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class base {
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();	
		
		FileInputStream fis = new FileInputStream("/Users/aparnachdhry/eclipse-workspace/E2EProject_2021/src/main/java/resources/data.properties");		
		
		prop.load(fis);
	  
	    
		String browserName = prop.getProperty("browser");

		
		if (browserName.equals("chrome")) {
           
			System.setProperty("webdriver.chrome.driver","/Users/aparnachdhry/Documents/Software/drivers/chromedriver/chromedriver");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver","/Users/aparnachdhry/Documents/Software/drivers/geckodriver/geckodriver");
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("safari")) {

			System.setProperty("webdriver.safari.driver", "/Macintosh HD/usr/bin/safaridriver");
			driver = new SafariDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

		// chrome
		// firefox
		// safari
	}
	
	public void getScreenShotPath(String testCaseName , WebDriver driver) throws IOException {
		System.out.println("inside screensthhot method");
		TakesScreenshot ts = (TakesScreenshot) driver;
		System.out.println("inside 1");
		File source = ts.getScreenshotAs(OutputType.FILE);
		System.out.println("inside 2");
	    String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
	    System.out.println("inside 3");
	    FileUtils.copyFile(source,new File(destinationFile));
	    System.out.println("inside 4");
	}
}



















