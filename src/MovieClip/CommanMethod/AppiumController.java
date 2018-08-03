package MovieClip.CommanMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumController {

    public static OS executionOS = OS.ANDROID;

    public enum OS {
        ANDROID,
        IOS
    }
    public static AppiumController instance = new AppiumController();
    public AppiumDriver<MobileElement> driver;

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        switch(executionOS){
            case ANDROID:
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app/Android");
                File app = new File (appDir, "baaz.apk");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("fullReset", false);
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "Nexus 5X API 27");
                capabilities.setCapability("platformVersion","8.1");
                //capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
                capabilities.setCapability("appPackage", "com.movieclips.views");
                capabilities.setCapability("appActivity", "com.movieclips.views.activity.SplashActivity");
                driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case IOS:
              
                capabilities = new DesiredCapabilities();
            //     capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("automationName","XCUITest");
                capabilities.setCapability("platformVersion", "10.3"); 
                capabilities.setCapability("deviceName", "iPhone Simulator"); 
                capabilities.setCapability("usePrebuiltWDA", "true");
                capabilities.setCapability("xcodeConfigFile", "/Users/tasoftware/file.xcconfig");
                capabilities.setCapability("app", "/Users/tasoftware/Documents/Payload.ipa"); 
                capabilities.setCapability("ipa", "/Users/tasoftware/Documents/Payload.ipa"); 
                //caps.setCapability("shouldUseSingletonTestManager", "true"); 
                //caps.setCapability("shouldUseTestManagerForVisibilityDetection","false");
                //caps.setCapability("shouldWaitForQuiescence","true");
                //caps.setCapability("showXcodeLog", "false"); 
                driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
