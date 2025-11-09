package appiumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
/*import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.JavascriptExecutor;

*/

public class LongPress extends BaseTest {

	@Test
	public void LongPressGuesture() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();

		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

		longPressAction(ele);

		String menuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

	}

}
