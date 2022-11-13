package org.ESPN.tests;

import org.ESPN.pages.BasePage;
import org.ESPN.pages.HomePage;
import org.ESPN.pages.LoginPage;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @Test
    public void enterLogIn() {
        home.startLogIn();
    }

}
