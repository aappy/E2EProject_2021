package Framework;

import java.io.IOException;

import org.testng.annotations.Test;

public class LoginPage extends base{
	
	@Test
	public void basePageNavigation() throws IOException{
		
		driver = initializeDriver();	
		driver.get("https://www.google.com");

	}
}
