package monefy.driver;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NEW_COMMAND_TIMEOUT;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobilePlatform;

public class DriverController {

  public static AndroidDriver<MobileElement> driver;

  public static void initDriver() {
    try {
      driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), getAndroidCapabilities());
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void stopDriver() {
    driver.quit();
  }

  private static DesiredCapabilities getAndroidCapabilities() {
    DesiredCapabilities androidCapabilities = new DesiredCapabilities();
    androidCapabilities.setCapability(AUTOMATION_NAME, "UiAutomator2");
    androidCapabilities.setCapability(PLATFORM_NAME, MobilePlatform.ANDROID);
    androidCapabilities.setCapability(DEVICE_NAME, "testDevice");
    androidCapabilities.setCapability(APP_PACKAGE, "com.monefy.app.lite");
    androidCapabilities.setCapability(APP_ACTIVITY, "com.monefy.activities.main.MainActivity_");
    androidCapabilities.setCapability(FULL_RESET, false);
    androidCapabilities.setCapability(NO_RESET, true);
    androidCapabilities.setCapability(DEVICE_READY_TIMEOUT, 3);
    androidCapabilities.setCapability(NEW_COMMAND_TIMEOUT, 300000);
    return androidCapabilities;
  }
}
