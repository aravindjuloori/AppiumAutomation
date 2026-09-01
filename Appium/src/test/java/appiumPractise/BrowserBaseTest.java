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

public class BrowserBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {

		// Starting Appium server programmatically
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Aravind\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start(); // To start appium server

		// Setting the Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("10BE1Y0BZM0012Y");
		options.setDeviceName("emulator-5554 ");
		options.setChromedriverExecutable("C:\\Users\\Aravind\\git\\Appium\\Appium\\src\\test\\java\\resources\\chromedriver.exe");
		// required
		options.setCapability("browserName", "Chrome");

		// Android device or ios device
		// appium code --> appium server
		URL appiumServerUrl = URI.create("http://127.0.0.1:4723").toURL();
		driver = new AndroidDriver(appiumServerUrl, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();

	}

}
