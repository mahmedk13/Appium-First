import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LongExample {

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
		MobileElement messages = driver.findElementByAccessibilityId("Messages");

		TouchAction action=new TouchAction(driver);
	//	action.press(ElementOption.element(phone)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(ElementOption.element(messages)).release().perform();
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(phone))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).release().perform();
		//action.longPress(LongPressOptions.tapOptions().withElement(ElementOption.element(phone))).release().perform();
	//	action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(phone))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).perform();
	//	action.press(ElementOption.element(phone)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).perform();
		
	
		
		driver.quit();

	}

}
