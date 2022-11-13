package org.ESPN.pages;

import org.ESPN.configuration.WebOperations;
import org.ESPN.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends WebOperations {
    @FindBy(id="global-user-trigger")
    private WebElement userSection;
    public BasePage(WebDriver driver) {
        super(driver);
    }
    public boolean isUserSectionDisplayed(){
        return userSection.isDisplayed();
    }

}
