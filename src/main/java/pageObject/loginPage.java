package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class loginPage {
	   private static Logger log = LogManager.getLogger(loginPage.class.getClass());

	public WebDriver driver;

	public loginPage(WebDriver driver2) {
		this.driver = driver2;
	}

	By submit = By.xpath("//*[@id=\"get-input\"]/button");
	By enterMessage = By.xpath("//*[@id='user-message']");

	public WebElement enterMessage() {
		log.warn("This is the warning   ....!"); 
		log.info("returning entermessage driver element");
		return driver.findElement(enterMessage);
		
	}

	public WebElement messageMethod() {
       log.info("returning submit driver element");
		return driver.findElement(submit);
	}
}
