import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumLearnning {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		File f= new File("C:\\Users\\MA005KH\\Downloads\\General-Store.apk");
		
		
		AndroidDriver<MobileElement> driver = null;
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		//caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.MainActivity");

		caps.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		
		driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		System.out.println("driver initialized!!!");
	   
		Thread.sleep(6000);
		driver.findElement(By.id("android:id/text1")).click();


		Thread.sleep(15000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));").click();;
		Thread.sleep(15000);

	
		driver.quit();
	
	}

}
