package org.ESPN.tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class LogOutTest extends BaseTest{

    @Test
    public void logOut() throws InterruptedException {
        home.endLogIn();
        checkThat("User Icon is present", home.isUserIconDisplayed(), is(true));
        home.logOut();
    }

}
