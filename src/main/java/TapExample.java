import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TapExample {

	public static void main(String[] args) throws MalformedURLException {
		
		
		AndroidDriver<MobileElement> driver = null;
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.nexuslauncher");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".NexusLauncherActivity");

		
		driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		System.out.println("driver initialized!!!");
		
		MobileElement phone = driver.findElementByAccessibilityId("Phone");
		TouchAction action=new TouchAction(driver);
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(phone))).release().perform();
		driver.quit();

	}

}
