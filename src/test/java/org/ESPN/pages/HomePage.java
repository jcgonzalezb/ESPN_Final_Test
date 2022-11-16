package org.ESPN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

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

    @FindBy(linkText="Log Out")
    private WebElement logOutText;

    @FindBy(css = "#global-viewport > div.global-user > div > ul.account-management > li:nth-child(5) > a")
    private WebElement espnProfile;

    @FindBy(css="#AccountDeleteLink")
    private WebElement accountDeleteLink;


    @FindBy(css= "body > div.promo-banner-container > iframe")
    private WebElement bannerIframe;
    @FindBy(css="#fittPageContainer > section > div.PromoBanner__CloseBtn")
    private WebElement bannerCloseBtn;

    public void closeBanner(){
        waitForBannerExistence(bannerIframe);
        clickElement(bannerCloseBtn);
    }

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

    public void profileOption() {
        accessingUserPanel();
        waitForVisibility(espnProfile);
        clickElement(espnProfile);
    }

    public void switchToModal() {
        super.getDriver().switchTo().frame(logInModal);
    }

    public void switchToMain() {super.getDriver().switchTo().defaultContent(); }


    public void insertCredentials () {
        String username = "anahousat089@hotmail.com";
        typeOnInput(usernameValue, username);
        String password = "8asuW-Mu21";
        typeOnInput(passwordValue, password);
        clickElement(logInButton);
        switchToMain();
    }

    public WatchPage watchPage() {
        waitForVisibility(watchIcon);
        clickElement(watchIcon);
        return new WatchPage(getDriver());
    }

    public void mouseHover() {
        waitForVisibility(userIcon);
        Actions action = new Actions(getDriver());
        action.moveToElement(userIcon).perform();
        waitForClickable(userIcon);
        clickElement(userIcon);
    }

    public String userNameConfirmation () {
        return userNameConfirmation.getText();
    }

    public String displayUsername () {
        return displayUserName.getText();
    }

    public void insideLogInModal() {
        insertCredentials();
        waitForInvisibility(logInModal);
    }


    public void logInComplete() {
        LogInOption();
        switchToModal();
        insideLogInModal();
        switchToMain();
    }


}
