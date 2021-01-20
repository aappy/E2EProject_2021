package Framework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import resources.base;


public class ValidateTitleTest extends base{
	WebDriver driver;
	private static Logger log = LogManager.getLogger(ValidateTitleTest.class.getClass());

	@Test
	public void validateTitle() throws IOException, Exception {
		
		log.debug("initialising driver in validateTitle");
		     driver = initializeDriver();
		log.info("ValidateTitleTest: driver initialized");
		log.debug("ValidateTitleTest: opeining URL");
		
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		log.info(" ValidateTitleTest: URL opened succsessfully ");
		
		Thread.sleep(4000);
		log.debug("clicking button");
		driver.findElement(By.xpath("//*[@id='at-cv-lightbox-button-holder']/a[2]")).click();
		
		log.debug("getting titles");
		String actual = driver.getTitle();
		
		log.debug("checking Assert");
		String expected ="XXXXXX";
		
		Assert.assertEquals(actual, expected);
	
			log.error("Title is mismatch");
	}
}
