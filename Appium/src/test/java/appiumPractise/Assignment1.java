package appiumPractise;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Assignment1 extends BaseTest {
	
	
	@Test
	public void allActions() {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"OK Cancel dialog with a message\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Single choice list\"]")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Satellite\"]")).click();
		
		
	}

}
