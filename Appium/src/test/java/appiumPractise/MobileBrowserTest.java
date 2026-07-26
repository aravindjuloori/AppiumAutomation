package appiumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {
	
	
	@Test
	public void browserTest() {
		
		
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Aravind Juloori");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	}

}
