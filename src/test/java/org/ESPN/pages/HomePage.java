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

    @FindBy(className = "account-management")
    private WebElement newFrame;

    @FindBy(linkText = "Log In")
    private WebElement LogInText;

    public boolean isUserSectionDisplayed(){
        return userSection.isDisplayed();
    }

    public void startLogIn() {
        waitForVisibility(userSection);
        clickElement(userSection);
        waitForVisibility(newFrame);
        clickElement(newFrame);
        waitForVisibility(LogInText);
        clickElement(LogInText);
    }


}
