package org.ESPN.tests;

import static java.lang.String.format;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.ESPN.configuration.Driver;
import org.ESPN.pages.HomePage;
import org.ESPN.reporting.Reporter;


public class BaseTest {
    private Driver driver;
    protected HomePage home;

    @Parameters({"browser", "url"})
    @BeforeTest()
    public void testSetup(String browser, String url) {
        driver = new Driver(browser);
        Reporter.info("Deleting all the cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        home = new HomePage(driver.getDriver());
    }
}
