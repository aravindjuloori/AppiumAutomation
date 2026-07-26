package appiumPractise;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {

		// Starting Appium server programatically

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Aravind\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start(); // To start appium server

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("10BE1Y0BZM0012Y");
//		options.setDeviceName("AravindEmulator");
		options.setPlatformName("Android");
		options.setChromedriverExecutable("C:\\Users\\Aravind\\git\\Appium\\Appium\\src\\test\\java\\resources\\chromedriver.exe");
		
		
//		options.setApp("C:\\Users\\Aravind\\git\\Appium\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\Aravind\\git\\Appium\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		

		// Android device or ios device
		// appium code --> appium server
		
         URL appiumserverurl = URI.create("http://127.0.0.1:4723").toURL(); 
		 driver=new AndroidDriver(appiumserverurl,options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
		 
		 //driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);  // if java version is less than 20 version this will work above java 20 version use URI class

	}

	public void longPressAction(WebElement ele) {
		
		((JavascriptExecutor)driver).executeScript("mobile:longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
	}

	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));
	}

	public void dragGesture(WebElement source, int endX, int endY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) source).getId(), "endX", endX, "endY", endY));

	}

	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));

		} while (canScrollMore);
	}

	public Double getFormattedAmount(String amount) {
	Double price=Double.parseDouble(amount.substring(1));
	return price;
}

	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop(); // to stop the appium server

	}

}
