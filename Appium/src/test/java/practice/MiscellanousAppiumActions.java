package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellanousAppiumActions extends BaseTest {
	
	@Test
	public void Misllenious() 
	{
		
		//Actual automation
		Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity" , ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscape=new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
		
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.setClipboardText("Aravind Wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//driver.findElement(By.id("android:id/button1")).click();
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	
		
		
	}

}
