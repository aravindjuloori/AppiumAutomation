package appiumPractise;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;


public class ScrollDemo extends BaseTest {

	@Test
	public void scrollDemoTest() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//where to scroll is known prior
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		//UiAutomator method which google has invented i.e.,androidUIAutomator
		
		//in google engine there is class called UiScrollable
			//selector to which we want to scroll in googleside we give Uiselector in appium we use driver.findelement
		
		//in this we use a method we dont have prior idea

		scrollToEndAction();
		
	
		
		

	}

}
