package appiumPractise;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {

	@Test
	public void WifiSettings() {

		driver.findElement(AppiumBy.accessibilityId("Preference")).click(); // Accessibility Id
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click(); // Xpath
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Aravind5G wifi");
		String popupTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
//	System.out.println(popupTitle);
		Assert.assertEquals(popupTitle, "WiFi settings");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
}
