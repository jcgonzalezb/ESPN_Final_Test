package org.ESPN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    private String username = "juankter@gmail.com";
    private String password = "6yFKiCT-";


    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="global-user-trigger")
    private WebElement userIcon;

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

    @FindBy(id = "InputLoginValue")
    private WebElement usernameValue;

    @FindBy(id = "InputPassword")
    private WebElement passwordValue;

    @FindBy(css = "#global-nav > ul > li.pillar.watch > a")
    private WebElement watchIcon;

    @FindBy(css = ".display-user > span")
    private WebElement userNameConfirmation;

    @FindBy(css = ".display-user")
    private WebElement displayUserName;

    @FindBy(css="#global-viewport > div.global-user > div > ul.account-management > li:nth-child(9) > a")
    private WebElement logOutText;


    public void switchToModal() {
        super.getDriver().switchTo().frame(logInModal);
    }

    public void switchToMain() {super.getDriver().switchTo().defaultContent(); }
    public boolean isLogInModalDisplayed(){
        super.waitForVisibility(logInModal);
        return logInModal.isDisplayed();
    }
    public boolean isEspnLogoDisplayed() {
        super.waitForVisibility(espnLogo);
        return espnLogo.isDisplayed(); }
    public boolean isLogInButtonDisplayed() {
        super.waitForVisibility(logInButton);
        return logInButton.isDisplayed(); }
    public boolean isSignUpButtonDisplayed() {
        super.waitForVisibility(signUpButton);
        return signUpButton.isDisplayed();
    }

    //public boolean isUsernameSpaceDisplayed() { return usernameValue.isDisplayed(); }
    //public boolean isPasswordSpaceDisplayed() { return passwordValue.isDisplayed(); }

    public boolean isUserIconDisplayed() { return userIcon.isDisplayed(); }

    public boolean isWatchIconDisplayed() { return watchIcon.isDisplayed(); }

    public boolean isUserCorrectDisplayed() { return userNameConfirmation.isDisplayed(); }

    public void accessingUserPanel() {
        waitForVisibility(userIcon);
        clickElement(userIcon);
        waitForVisibility(menu);
        clickElement(menu);
    }

    public void LogInOption() {
        accessingUserPanel();
        waitForVisibility(logInText);
        clickElement(logInText);
    }
    public void logOutOption() {
        accessingUserPanel();
        waitForVisibility(logOutText);
        clickElement(logOutText);
    }




    public void endLogIn () {
        typeOnInput(usernameValue, username);
        typeOnInput(passwordValue, password);
        clickElement(logInButton);
        switchToMain();
        waitForVisibility(userIcon);
        waitForClickable(userIcon);
    }

    public WatchPage watchPage() {
        waitForVisibility(watchIcon);
        clickElement(watchIcon);
        return new WatchPage(getDriver());
    }

    public void mouseHover() {
        Actions action = new Actions(getDriver());
        action.moveToElement(userIcon).perform();
    }

    public String userNameConfirmation () {
        return userNameConfirmation.getText();
    }

    public String displayUsername () {
        return displayUserName.getText();
    }





    public void logOut () throws InterruptedException {
        Actions action = new Actions(getDriver());
        action.moveToElement(userIcon).perform();
        Thread.sleep(15000);
        clickElement(userIcon);
        //waitForVisibility(menu);
        //clickElement(menu);
        //waitForVisibility(logInText);
        //clickElement(logInText);
    }

}
