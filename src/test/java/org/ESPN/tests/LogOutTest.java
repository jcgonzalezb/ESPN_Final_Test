package org.ESPN.tests;


import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class LogOutTest extends BaseTest{

    @Test
    public void logOut() {
        home.logInComplete();
        home.mouseHoverUserIcon();
        home.accessingUserPanel();
        home.logOutOption();
        home.switchToMain();
        home.mouseHoverUserIcon();
        home.accessingUserPanel();
        checkThat("The element 'Nav text'\n" +
                "has text: 'Welcome!' without user name specified", home.displayUsername(), is("Welcome!"));
    }

}
