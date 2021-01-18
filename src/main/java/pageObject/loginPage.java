package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class loginPage {

	public WebDriver driver;

	public loginPage(WebDriver driver2) {
		this.driver = driver2;
	}

	By submit = By.xpath("//*[@id=\"get-input\"]/button");
	By enterMessage = By.xpath("//*[@id='user-message']");

	public WebElement enterMessage() {

		return driver.findElement(enterMessage);
	}

	public WebElement messageMethod() {

		return driver.findElement(submit);
	}
}
