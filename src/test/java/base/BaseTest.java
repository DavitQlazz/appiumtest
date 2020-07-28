package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static factory.DriverProvider.driverPool;
import static factory.DriverProvider.getDriver;

public class BaseTest {

    public AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void newDriver() {
        this.driver = getDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (driverPool.get() != null) {
            driverPool.remove();
            System.out.println("Delete Driver");
        }
    }
}
