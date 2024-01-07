package com.mitigram.assignment.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends PageBase {
    @FindBy(tagName = "h4")
    private WebElement heading;
    @FindBy(id = "Email")
    private WebElement emailTxt;
    @FindBy(css = "[value=\"Email link\"]")
    private WebElement emailLinkBtn;
    @FindBy(linkText = "I already have an account")
    private WebElement alreadyHaveAnAccountLnk;

    //Use 'By' locators for dynamically loaded elements
    private final By paragraph = By.tagName("p");
    private final By backToLoginLnk = By.linkText("Back to Login");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public void enterEmail(String email) {
        emailTxt.sendKeys(email);
    }

    public void clickEmailLinkButton() {
        emailLinkBtn.click();
    }

    public void clickAlreadyHaveAnAccountLink() {
        alreadyHaveAnAccountLnk.click();
    }

    public String getParagraphText() {
        return waitUntilElementIsLocatedAndDisplayed(paragraph).getText();
    }

    public void clickBackToLoginLink() {
        waitUntilElementIsLocatedAndDisplayed(backToLoginLnk).click();
    }

    public String getEmailFieldValidationMessage() {
        return emailTxt.getAttribute("validationMessage");
    }

    public void clearEmail() {
        emailTxt.clear();
    }
}
