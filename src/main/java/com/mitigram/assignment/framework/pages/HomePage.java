package com.mitigram.assignment.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(linkText = "Log in")
    private WebElement loginBtn;
    @FindBy(linkText = "Careers")
    private WebElement careersLnk;

    //Other elements on the home page should be added here

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public void clickCareersLink() {
        careersLnk.click();
    }

    //Other home page actions should be added here
}
