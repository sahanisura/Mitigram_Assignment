package com.mitigram.assignment.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage {
    @FindBy(id = "newsletterUserMail")
    private WebElement newsletterEmailTxt;
    @FindBy(className = "bfCustomSubmitButton")
    private WebElement newsletterSubmitButton;
    @FindBy(id = "newsletterErrorMessage")
    private WebElement newsletterErrorMessage;
    @FindBy(className = "form-notification")
    private WebElement newsletterMsgReceivedNotification;

    public NewsletterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickNewsletterSubmitButton() {
        newsletterSubmitButton.click();
    }

    public void enterNewsletterEmail(String email) {
        newsletterEmailTxt.sendKeys(email);
    }

    public String getNewsletterErrorMessage() {
        return newsletterErrorMessage.getText();
    }

    public String getNewsletterMsgReceivedNotificationHeader() {
        return newsletterMsgReceivedNotification.findElement(By.tagName("h5")).getText();
    }

    public String getNewsletterMsgReceivedNotificationParagraph() {
        return newsletterMsgReceivedNotification.findElement(By.tagName("p")).getText();
    }

    public void clickNewsletterMsgReceivedNotificationDismissButton() {
        newsletterMsgReceivedNotification.findElement(By.tagName("button")).click();
    }

    public boolean isNewsletterMsgReceivedNotificationVisible() {
        return !newsletterMsgReceivedNotification.getCssValue("display").equals("none");
    }
}
