package iOS;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSScrollDemo extends IOSBaseTest{
	
	
	@Test
	public void ScrollDemo() {
		
		WebElement ele=driver.findElement(AppiumBy.accessibilityId("Web View"));
		
		Map<String,Object> params=new HashMap<>();
		params.put("element",((RemoteWebElement)ele).getId());
		params.put("direction","down");
		
		
		driver.executeScript("mobile:scroll",params);
		driver.findElement(AppiumBy.accessibilityId("Web View")).click();
		
		
		
	
		
	}

}
