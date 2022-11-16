package org.ESPN.tests;

import org.testng.annotations.Test;
public class DeactivateAccountTest extends BaseTest {
    @Test
    public void DeactivateAccount()  {
        home.logInComplete();
        home.mouseHoverUserIcon();
        home.accessingUserPanel();
        home.profileOption();
        home.switchToUpdateAccount();
        home.insideUpdateForm();
        //home.switchToConfirmation();
        home.insideDeleteConfirmationForm();
        home.switchToMain();
        home.LogInOption();
        home.switchToModal();
        //Thread.sleep(15000);
        //home.insertCredentials()
    }





}
