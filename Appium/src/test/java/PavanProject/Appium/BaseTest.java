
package PavanProject.Appium;

import java.io.File;
import java.net.MalformedURLException;
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
	public void ConfigureAppium() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\pavan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.1.6").usingPort(4723).build();
		service.start();
//    	C:\Users\pavan\AppData\Roaming\npm\node_modules\appium\build\lib\main
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pavanemulator");
		options.setApp(
				"C:\\Users\\pavan\\OneDrive\\Desktop\\Mobile Testing\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		// Initialize AndroidDriver
		driver = new AndroidDriver(new URL("http://192.168.1.6:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void Teardown() {
		driver.quit();
		service.stop();
	}
}
