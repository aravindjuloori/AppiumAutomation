package appiumPractise;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		// Starting Appium server programatically
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Aravind\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("10BE1Y0BZM0012Y");
		options.setPlatformName("Android");
		options.setApp("C:\\Users\\Aravind\\git\\Appium\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
//		options.setApp("C:\\Users\\Aravind\\git\\Appium\\Appium\\src\\test\\java\\resources\\General-Store.apk");

//		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);  //if java version is below 20 it will work because java version above 20 URL class is deprecated
//		AndroidDriver driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options); 

		// Android device or ios device
		// appium code --> appium server

		URL appiumserverurl = URI.create("http://127.0.0.1:4723").toURL();
		driver = new AndroidDriver(appiumserverurl, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void teardown() {

		driver.quit();
		service.stop(); // to stop the appium server
	}

}
