package MovieClip.CommanMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public abstract class AppiumBaseClass {

    protected AppiumDriver<MobileElement> driver() {
        return AppiumController.instance.driver;
    }
}
