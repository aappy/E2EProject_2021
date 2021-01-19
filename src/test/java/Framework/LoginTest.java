package Framework;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObject.loginPage;
import resources.base;

public class LoginTest extends base{
	
   private static Logger log = LogManager.getLogger(LoginTest.class.getClass());
	
	@Test
	public void basePageNavigation() throws IOException, Exception{
		
		log.debug("initialising driver");
		
		driver = initializeDriver();
		
		log.info("driver initialized");
	    log.debug("opeining URL");
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		log.info(" URL opened succsessfully");
	
		Thread.sleep(4000);
		log.debug("clicking button");
		driver.findElement(By.xpath("//*[@id='at-cv-lightbox-button-holder']/a[2]")).click();
		
		log.info("button clicked successfully");
		
		loginPage obj = new loginPage(driver);
		
		log.debug("entering message");
		obj.enterMessage().sendKeys("Apaarna");;
		
		log.info("Entered message");
        obj.messageMethod().click();
        
	}
}
