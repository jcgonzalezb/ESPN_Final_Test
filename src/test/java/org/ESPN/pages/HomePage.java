package org.ESPN.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(css= "body > div.promo-banner-container > iframe")
    private WebElement bannerIframe;
    @FindBy(css="#fittPageContainer > section > div.PromoBanner__CloseBtn")
    private WebElement bannerCloseBtn;

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

    @FindBy(linkText="ESPN Profile")
    private WebElement espnProfile;

    @FindBy(css= "div#oneid-wrapper > iframe#oneid-iframe")
    private WebElement UpdateAccountForm;

    @FindBy(id="AccountDeleteLink")
    private WebElement accountDeleteLink;

    @FindBy(id= "BtnSubmit")
    private WebElement deleteAccountConfirmationButton;


    public void closeBanner(){
        waitForFrameExistence(bannerIframe);
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
    public void accessingUserPanel() {
        waitForVisibility(userIcon);
        waitForClickable(userIcon);
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

    public void switchToUpdateAccount() { super.getDriver().switchTo().frame(UpdateAccountForm); }

    public void insertCredentials () {
        String username = "juantesat1@hotmail.com";
        typeOnInput(usernameValue, username);
        String password = "i8qmK-A34";
        typeOnInput(passwordValue, password);
        clickElement(logInButton);
    }

    public WatchPage watchPage() {
        waitForVisibility(watchIcon);
        clickElement(watchIcon);
        return new WatchPage(getDriver());
    }

    public void mouseHoverUserIcon() {
        waitForVisibility(userIcon);
        Actions action = new Actions(getDriver());
        action.moveToElement(userIcon).perform();
        waitForClickable(userIcon);
        clickElement(userIcon);
    }

    public String userNameConfirmation ()    {
        waitForVisibility(userNameConfirmation);
        return userNameConfirmation.getText();
    }
    public String displayUsername () {
        return displayUserName.getText();
    }

    public void insideLogInModal() {
        insertCredentials();
        switchToMain();
        waitForInvisibility(logInModal);
    }

    public void logInComplete() {
        LogInOption();
        switchToModal();
        insideLogInModal();
        switchToMain();
    }

    public void insideUpdateForm() {
        waitForVisibility(accountDeleteLink);
        waitForClickable(accountDeleteLink);
        clickElement(accountDeleteLink);
        waitForInvisibility(UpdateAccountForm);
    }

    public void insideDeleteConfirmationForm() {
        waitForVisibility(deleteAccountConfirmationButton);
        waitForClickable(deleteAccountConfirmationButton);
        clickElement(deleteAccountConfirmationButton);
        waitForInvisibility(deleteAccountConfirmationButton);
    }
}
