package com.mitigram.assignment.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    @FindBy(linkText = "Log in")
    private WebElement loginBtn;
    @FindBy(linkText = "Careers")
    private WebElement careersLnk;
    @FindBy(css = "[aria-label=\"dismiss cookie message\"]")
    private WebElement acceptCookiesBtn;

    //Other elements on the home page should be added here

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public void clickCareersLink() {
        careersLnk.click();
    }

    public void clickAcceptCookies() {
        acceptCookiesBtn.click();
    }

    public boolean isAcceptCookiesButtonVisible() {
        return acceptCookiesBtn.isDisplayed();
    }

    //Other home page actions should be added here
}
