package org.ESPN.tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;
public class DeactivateAccountTest extends BaseTest {
    @Test
    public void DeactivateAccount()  {
        //home.logInComplete();
        home.mouseHover();
        home.accessingUserPanel();
        home.profileOption();
    }





}
