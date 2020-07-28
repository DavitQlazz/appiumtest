package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static factory.DriverProvider.CASINO_PACKAGE_ID;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends BasePage {

    @FindBy(id = CASINO_PACKAGE_ID + ":id/sign_in")
    private MobileElement signIn;

    @FindBy(id = CASINO_PACKAGE_ID + ":id/registration")
    private MobileElement registration;

    @FindBy(id = CASINO_PACKAGE_ID + ":id/back_button")
    private MobileElement backButton;

    WebDriverWait wait = new WebDriverWait(driver, 15);

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void clickSignIn() {
        wait.until(elementToBeClickable(signIn)).click();
    }

    public void clickBackButton() {
        wait.until(elementToBeClickable(backButton)).click();
    }

    public void clickRegistration() {
        wait.until(elementToBeClickable(registration)).click();
    }
}
