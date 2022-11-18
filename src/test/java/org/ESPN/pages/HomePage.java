package org.ESPN.pages;

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

    @FindBy (css = ".account-deleted-gating + #Title")
    private  WebElement accountDeactivatedMessage;

    public void closeBanner(){
        super.waitForFrameExistence(bannerIframe);
        super.clickElement(bannerCloseBtn);
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
        super.waitForVisibility(userIcon);
        super.waitForClickable(userIcon);
        super.clickElement(userIcon);
        super.waitForVisibility(menu);
        super.clickElement(menu);
    }

    public void LogInOption() {
        accessingUserPanel();
        super.waitForVisibility(logInText);
        super.clickElement(logInText);
    }
    public void logOutOption() {
        accessingUserPanel();
        super.waitForVisibility(logOutText);
        super.clickElement(logOutText);
    }

    public void profileOption() {
        accessingUserPanel();
        super.waitForVisibility(espnProfile);
        super.clickElement(espnProfile);
    }

    public void switchToModal() {
        super.getDriver().switchTo().frame(logInModal);
    }

    public void switchToMain() {super.getDriver().switchTo().defaultContent(); }

    public void switchToUpdateAccount() { super.getDriver().switchTo().frame(UpdateAccountForm); }

    public void insertCredentials () {
        String username = "juantesat1@hotmail.com";
        super.typeOnInput(usernameValue, username);
        String password = "auvR$k7tz9vJuH$";
        super.typeOnInput(passwordValue, password);
        super.clickElement(logInButton);
    }

    public WatchPage watchPage() {
        super.waitForVisibility(watchIcon);
        super.clickElement(watchIcon);
        return new WatchPage(getDriver());
    }

    public void mouseHoverUserIcon() {
        super.waitForVisibility(userIcon);
        Actions action = new Actions(getDriver());
        action.moveToElement(userIcon).perform();
        super.waitForClickable(userIcon);
        super.clickElement(userIcon);
    }

    public String userNameConfirmation ()    {
        super.waitForVisibility(userNameConfirmation);
        return userNameConfirmation.getText();
    }
    public String displayUsername () {
        return displayUserName.getText();
    }

    public void insideLogInModal() {
        insertCredentials();
        switchToMain();
        super.waitForInvisibility(logInModal);
    }

    public void logInComplete() {
        LogInOption();
        switchToModal();
        insideLogInModal();
        switchToMain();
    }

    public void insideUpdateForm() {
        super.waitForVisibility(accountDeleteLink);
        super.waitForClickable(accountDeleteLink);
        super.clickElement(accountDeleteLink);
        super.waitForInvisibility(UpdateAccountForm);
    }

    public void insideDeleteConfirmationForm() {
        super.waitForVisibility(deleteAccountConfirmationButton);
        super.waitForClickable(deleteAccountConfirmationButton);
        super.clickElement(deleteAccountConfirmationButton);
        super.waitForVisibility(deleteAccountConfirmationButton);
        super.waitForClickable(deleteAccountConfirmationButton);
        super.clickElement(deleteAccountConfirmationButton);
        super.waitForInvisibility(deleteAccountConfirmationButton);
        super.waitForInvisibility(deleteAccountConfirmationButton);
    }

    public String getAccountDeactivatedMessage() {
        super.waitForVisibility(accountDeactivatedMessage);
        return this.accountDeactivatedMessage.getText();
    }
}
