package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void initPages() {
       homePage = new HomePage(driver);
    }

    @Test
    public void testName() {
        homePage.clickSignIn();
        homePage.clickBackButton();
    }
    @Test
    public void testName1() {
        homePage.clickSignIn();
        homePage.clickBackButton();
        homePage.clickSignIn();
    }
    @Test
    public void testName11() {
        homePage.clickRegistration();
        homePage.clickBackButton();
        homePage.clickSignIn();
    }
    @Test
    public void testName111() {
        homePage.clickRegistration();
        homePage.clickBackButton();
        homePage.clickSignIn();
    }
}
