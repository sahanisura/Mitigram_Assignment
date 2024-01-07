package com.mitigram.assignment.framework.test;

import com.mitigram.assignment.framework.steps.CommonSteps;
import com.mitigram.assignment.framework.steps.NewsletterSectionSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewsletterTests extends TestBase {
    private CommonSteps commonSteps;
    private NewsletterSectionSteps newsletterSectionSteps;

    @BeforeMethod(dependsOnMethods = "testBaseBeforeMethod")
    public void beforeMethod() {
        commonSteps = new CommonSteps();
        newsletterSectionSteps = new NewsletterSectionSteps();
    }

    @Test
    public void testSubmitNewsletterEmailWithValidEmail() {
        commonSteps.navigateToPage("home");
        newsletterSectionSteps.enterNewsletterEmail("validEmail@gmail.com");
        newsletterSectionSteps.clickNewsletterEmailSubmitButton();
        newsletterSectionSteps.validateNewsletterMsgReceivedNotificationHeader("THANK YOU!");
        newsletterSectionSteps.validateNewsletterMsgReceivedNotificationParagraph("We received your message and " +
                "we will get back with available times.");
        newsletterSectionSteps.clickNewsletterMsgReceivedNotificationDismissButton();
        newsletterSectionSteps.validateNewsletterMsgReceivedNotificationIsNotVisible();
        assertAll();
    }

    @Test
    public void testSubmitNewsletterEmailWithInvalidEmailFormat() {
        commonSteps.navigateToPage("home");
        newsletterSectionSteps.enterNewsletterEmail("invalidFormat");
        newsletterSectionSteps.clickNewsletterEmailSubmitButton();
        newsletterSectionSteps.validateNewsletterErrorMessage("Email address is invalid.");
        assertAll();
    }

    @Test
    public void testClickNewsletterSubmitButtonWithoutEmail() {
        commonSteps.navigateToPage("home");
        newsletterSectionSteps.clickNewsletterEmailSubmitButton();
        newsletterSectionSteps.validateNewsletterErrorMessage("Email address is invalid.");
        assertAll();
    }
}
