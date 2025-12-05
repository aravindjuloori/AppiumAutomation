package appiumPractise;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest{

	@Test
	public void wifiSettingName() throws MalformedURLException

	{

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi setting");

		driver.findElement(By.id("android:id/edit")).sendKeys("AravindWifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click(); // multiple elements with the same classname
	}

}
