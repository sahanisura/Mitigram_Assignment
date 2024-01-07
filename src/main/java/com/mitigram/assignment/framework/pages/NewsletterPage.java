package com.mitigram.assignment.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsletterPage extends PageBase {
    @FindBy(id = "newsletterUserMail")
    private WebElement emailTxt;
    @FindBy(className = "bfCustomSubmitButton")
    private WebElement submitButton;
    @FindBy(id = "newsletterErrorMessage")
    private WebElement errorLabel;
    @FindBy(className = "form-notification")
    private WebElement messageReceivedNotification;

    public NewsletterPage(WebDriver driver) {
        super(driver);
    }

    public void clickNewsletterSubmitButton() {
        submitButton.click();
    }

    public void enterNewsletterEmail(String email) {
        emailTxt.sendKeys(email);
    }

    public String getNewsletterErrorMessage() {
        return waitUntilElementIsDisplayed(errorLabel).getText();
    }

    public String getNewsletterMsgReceivedNotificationHeader() {
        return waitUntilElementIsDisplayed(messageReceivedNotification)
                .findElement(By.tagName("h5")).getText();
    }

    public String getNewsletterMsgReceivedNotificationParagraph() {
        return waitUntilElementIsDisplayed(messageReceivedNotification)
                .findElement(By.tagName("p")).getText();
    }

    public void clickNewsletterMsgReceivedNotificationDismissButton() {
        waitUntilElementIsDisplayed(messageReceivedNotification)
                .findElement(By.tagName("button")).click();
    }

    public boolean isNewsletterMsgReceivedNotificationVisible() {
        return messageReceivedNotification.isDisplayed();
    }
}
