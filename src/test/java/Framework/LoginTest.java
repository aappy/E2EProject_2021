package Framework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObject.loginPage;
import resources.base;

public class LoginTest extends base{
	
	@Test
	public void basePageNavigation() throws IOException, Exception{
		
		driver = initializeDriver();	
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[@id='at-cv-lightbox-button-holder']/a[2]")).click();
		loginPage obj = new loginPage(driver);
		obj.enterMessage().sendKeys("Apaarna");;
        obj.messageMethod().click();
	
	
	}
}
