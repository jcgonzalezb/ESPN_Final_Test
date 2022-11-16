package org.ESPN.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends BasePage{

    public WatchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css="#fittPageContainer > section > div:nth-child(1) > section")
    private WebElement firstCarousel;

    @FindBy (css = "section.Carousel")
    private List<WebElement> carouselList;

    @FindBy(css="#fittPageContainer > section > div:nth-child(1) > section > div.Carousel__Wrapper.relative.Carousel__Wrapper--canScrollRight > div > div > ul > li:nth-child(2)")
    private WebElement secondCardFirstCarousel;

    @FindBy(css=".lightbox__closebtn")
    private WebElement xButton;

    public boolean isFirstCarouselDisplayed() {
        super.waitForVisibility(firstCarousel);
        return firstCarousel.isDisplayed();
    }
    public boolean isSecondCardDisplayed() {
        super.waitForVisibility(secondCardFirstCarousel);
        return secondCardFirstCarousel.isDisplayed();
    }
    public boolean isxButtonDisplayed() {
        super.waitForVisibility(xButton);
        return xButton.isDisplayed();
    }

    public void clickOnxButton(){
        super.waitForClickable(xButton);
        super.clickElement(xButton);
    }

    public void clickOnSecondCard(){
        waitForVisibility(secondCardFirstCarousel);
        waitForClickable(secondCardFirstCarousel);
        clickElement(secondCardFirstCarousel);
    }

    public void returnToHome(){
        super.getDriver().navigate().back();
    }
}
