package org.ESPN.tests;

import org.ESPN.pages.HomePage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LogInTest extends BaseTest {

    @Test
    public void enterLogIn() {
        home.startLogIn();
        checkThat("Modal is present", home.isLogInModalDisplayed(), is(true));
        home.switchToModal();
        checkThat("ESPN logo is present", home.isEspnLogoDisplayed(), is(true));
        checkThat("Log In button is present", home.isLogInButtonDisplayed(), is(true));
        checkThat("Sign Up button is present", home.isSignUpButtonDisplayed(), is(true));
        //checkThat("Username is present", home.isUsernameSpaceDisplayed(), is(true));
        //checkThat("Password is present", home.isPasswordSpaceDisplayed(), is(true));
        home.endLogIn();
        home.switchToMain();
        //checkThat("User Icon is present", home.isUserIconDisplayed(), is(true));
        //home.logOut();
    }

}
