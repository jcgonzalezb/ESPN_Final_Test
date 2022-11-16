package org.ESPN.tests;

import org.ESPN.pages.WatchPage;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class LogOutTest extends BaseTest{

    @Test
    public void logOut() throws InterruptedException {
        //Thread.sleep(5000);
        //home.logInComplete();
        home.mouseHover();
        home.accessingUserPanel();
        //home.logOutOption();
        //home.mouseHover();
        //home.accessingUserPanel();
        checkThat("The element 'Nav text'\n" +
                "has text: 'Welcome!' without user name specified", home.displayUsername(), is("Welcome!"));
    }

}
