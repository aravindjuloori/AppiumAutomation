package appiumPractise;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {

	@Test
	public void scrollDemoTest() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		// where to scroll is known prior with this method
		// UiAutomator method which google has invented i.e.,androidUIAutomator

		// in google engine there is class called UiScrollable
		// selector to which we want to scroll in googleside we give Uiselector in
		// appium we use driver.findelement

//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));

		scrollToEndAction();

//		boolean canScrollMore=(Boolean) ((JavascriptExecutor)driver).executeScript("mobile:scrollGesture",ImmutableMap.of("left",100,"top",100,"height",200,"width",200,"direction","down","percent",3.0));
	}

}
