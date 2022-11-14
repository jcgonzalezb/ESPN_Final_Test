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

    @FindBy(id ="logo")
    private WebElement espnLogo;

    @FindBy (id = "BtnSubmit")
    private WebElement logInButton;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;

    public void switchToModal() {
        super.getDriver().switchTo().frame(this.logInModal);
    }
    public boolean isLogInModalDisplayed(){
        super.waitForVisibility(logInModal);
        return logInModal.isDisplayed();
    }
    public boolean isEspnLogoDisplayed() {
        super.waitForVisibility(espnLogo);
        return espnLogo.isDisplayed(); }
    public boolean isLogInButtonDisplayed() {
        //super.waitForVisibility(logInButton);
        return logInButton.isDisplayed(); }
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
