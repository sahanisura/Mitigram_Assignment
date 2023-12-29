package com.mitigram.assignment.framework.pages;

import com.mitigram.assignment.framework.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    @FindBy(linkText = "Log in")
    private WebElement loginBtn;
    @FindBy(linkText = "Careers")
    private WebElement careersLnk;

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

    //Other home page actions should be added here
}
