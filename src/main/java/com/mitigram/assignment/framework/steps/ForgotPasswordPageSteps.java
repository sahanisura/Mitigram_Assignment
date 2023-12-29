package com.mitigram.assignment.framework.steps;

import com.mitigram.assignment.framework.base.StepBase;
import com.mitigram.assignment.framework.pages.ForgotPasswordPage;

public class ForgotPasswordPageSteps extends StepBase {
    private ForgotPasswordPage forgotPasswordPage;

    @Override
    protected void initPages() {
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    public void validateHeaderText(String expectedHeaderText) {
        String actualHeaderText = forgotPasswordPage.getHeadingText();
        softAssert.assertEquals(actualHeaderText, expectedHeaderText);
    }

    public void enterEmail(String email) {
        forgotPasswordPage.enterEmail(email);
    }

    public void clickEmailLinkButton() {
        forgotPasswordPage.clickEmailLinkButton();
    }

    public void validateParagraphText(String expectedParagraphMessage) {
        String actualParagraphMessage = forgotPasswordPage.getParagraphText();
        softAssert.assertEquals(actualParagraphMessage, expectedParagraphMessage);
    }

    public void clickAlreadyHaveAnAccount() {
        forgotPasswordPage.clickAlreadyHaveAnAccountLink();
    }

    public void clickBackToLoginLink() {
        forgotPasswordPage.clickBackToLoginLink();
    }

    public void validateEmailFieldValidationMessage(String expectedValidationMessage) {
        softAssert.assertEquals(forgotPasswordPage.getEmailFieldValidationMessage(), expectedValidationMessage);
    }

    public void clearEmail() {
        forgotPasswordPage.clearEmail();
    }
}
