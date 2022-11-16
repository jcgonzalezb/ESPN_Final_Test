package org.ESPN.tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;
public class DeactivateAccountTest extends BaseTest {
    @Test
    public void DeactivateAccount()  {
        home.logInComplete();
        home.mouseHoverUserIcon();
        home.accessingUserPanel();
        home.profileOption();
        home.switchToUpdateAccount();
        home.insideUpdateForm();
        home.switchToConfirmation();
        home.DeleteConfirmationForm();
        home.switchToMain();
    }





}
