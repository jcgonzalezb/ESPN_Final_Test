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
    private WebElement Menu;

    @FindBy(css= "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement LogInText;

    @FindBy(id = "div#oneid-wrapper > iframe#oneid-iframe")
    private WebElement LogInModal;

    @FindBy(id="InputLoginValue")
    private WebElement email;

    public boolean isUserSectionDisplayed(){
        return userSection.isDisplayed();
    }

    public void startLogIn() {
        waitForVisibility(userSection);
        clickElement(userSection);
        waitForVisibility(Menu);
        clickElement(Menu);
        waitForVisibility(LogInText);
        clickElement(LogInText);
        waitForVisibility(LogInModal);
        clickElement(email);


    }


}
