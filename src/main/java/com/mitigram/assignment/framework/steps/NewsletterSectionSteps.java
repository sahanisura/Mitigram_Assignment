package com.mitigram.assignment.framework.steps;

import com.mitigram.assignment.framework.pages.NewsletterPage;
import org.testng.asserts.SoftAssert;

import static com.mitigram.assignment.framework.utils.TestContext.*;

public class NewsletterSectionSteps {
    private final SoftAssert softAssert;
    private NewsletterPage newsletterPage;

    public NewsletterSectionSteps() {
        this.softAssert = getSoftAssert();
        initPages();
    }

    protected void initPages() {
        newsletterPage = new NewsletterPage(getDriver());
    }

    public void enterNewsletterEmail(String email) {
        newsletterPage.enterNewsletterEmail(email);
    }

    public void clickNewsletterEmailSubmitButton() {
        newsletterPage.clickNewsletterSubmitButton();
    }

    public void clickNewsletterMsgReceivedNotificationDismissButton() {
        newsletterPage.clickNewsletterMsgReceivedNotificationDismissButton();
    }

    public void validateNewsletterMsgReceivedNotificationHeader(String expectedText) {
        softAssert.assertEquals(newsletterPage.getNewsletterMsgReceivedNotificationHeader(), expectedText);
    }

    public void validateNewsletterMsgReceivedNotificationParagraph(String expectedText) {
        softAssert.assertEquals(newsletterPage.getNewsletterMsgReceivedNotificationParagraph(), expectedText);
    }

    public void validateNewsletterMsgReceivedNotificationIsNotVisible() {
        softAssert.assertEquals(newsletterPage.isNewsletterMsgReceivedNotificationVisible(), false,
                "Newsletter message received notification is visible.");
    }

    public void validateNewsletterErrorMessage(String expectedError) {
        softAssert.assertEquals(newsletterPage.getNewsletterErrorMessage(), expectedError);
    }
}
