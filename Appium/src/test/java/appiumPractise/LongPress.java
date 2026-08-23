package appiumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {

	@Test
	public void LongPressGuesture() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

		// For performing long press in appium has provide the gesture

//		((JavascriptExecutor)driver).executeScript("mobile:longClickGesture",
//				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));

		longPressAction(ele);
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

	}

}
