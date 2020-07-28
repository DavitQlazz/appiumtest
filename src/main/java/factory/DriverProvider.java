package factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static factory.AppiumServer.getService;
import static io.appium.java_client.remote.MobileCapabilityType.*;

/**
 * The type Driver provider.
 */
public class DriverProvider {

    public static final String CASINO_PACKAGE_ID = "com.vivarobet.casino";
    private static final String CASINO_APP_MAIN_ACTIVITY = "com.betconstruct.casino.MainActivity";
    public static final ThreadLocal<AppiumDriver<MobileElement>>
            driverPool = new ThreadLocal<>();

    private static DesiredCapabilities getAndroidCaps() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, MobilePlatform.ANDROID);
//        capabilities.setCapability(MobileCapabilityType.UDID, "");
        capabilities.setCapability(APP, "src\\main\\resources\\app\\casino-vivarobet.apk");
        capabilities.setCapability(NO_RESET, true);
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, 2200);
        capabilities.setCapability("appPackage", CASINO_PACKAGE_ID);
        capabilities.setCapability("noSign", true);
        capabilities.setCapability("appActivity", CASINO_APP_MAIN_ACTIVITY);
        capabilities.setCapability("deviceReadyTimeout", 10);
        capabilities.setCapability("ignoreUnimportantViews", true);
        capabilities.setCapability("disableAndroidWatchers", true);
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }

    private static void createDriver() {
        AppiumDriver<MobileElement> driver = new AppiumDriver<>(getService(), getAndroidCaps());
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driverPool.set(driver);
    }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public static AppiumDriver<MobileElement> getDriver() {
        if (driverPool.get() == null) {
            createDriver();
        }
        return driverPool.get();
    }

}
