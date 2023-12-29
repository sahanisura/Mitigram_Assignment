package com.mitigram.assignment.framework.steps;

import com.mitigram.assignment.framework.pages.NewsletterPage;

public class NewsletterSectionSteps extends StepBase {
    private NewsletterPage newsletterPage;

    @Override
    protected void initPages() {
        newsletterPage = new NewsletterPage(driver);
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
