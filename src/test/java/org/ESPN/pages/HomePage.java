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

    public boolean isUserSectionDisplayed(){
        return userSection.isDisplayed();
    }

    public void startLogIn() {
        waitForVisibility(userSection);
        clickElement(userSection);
    }


}
