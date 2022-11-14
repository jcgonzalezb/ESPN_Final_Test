package org.ESPN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="global-user-trigger")
    private WebElement userSection;

    @FindBy(className = "global-user-container")
    private WebElement menu;

    @FindBy(css= "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement logInText;

    @FindBy(css = "div#oneid-wrapper > iframe#oneid-iframe")
    private WebElement logInModal;

    @FindBy(id="logo")
    private WebElement espnLogo;

    @FindBy(id = "BtnSubmit")
    private WebElement logInButton;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;

    public boolean isLogInModalDisplayed(){
        return logInModal.isDisplayed();
    }
    public boolean isEspnLogoDisplayed() { return espnLogo.isDisplayed(); }
    public boolean isLogInButtonDisplayed() { return logInButton.isDisplayed(); }
    public boolean isSignUpButtonDisplayed() { return signUpButton.isDisplayed(); }


    public void startLogIn() {
        waitForVisibility(userSection);
        clickElement(userSection);
        waitForVisibility(menu);
        clickElement(menu);
        waitForVisibility(logInText);
        clickElement(logInText);
        //waitForVisibility(logInModal);
    }

}
