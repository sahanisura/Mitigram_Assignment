package com.mitigram.assignment.framework.steps;

import com.mitigram.assignment.framework.pages.LoginPage;

public class LoginPageSteps extends StepBase {
    private LoginPage loginPage;

    @Override
    protected void initPages() {
        loginPage = new LoginPage(driver);
    }

    public void validateLogoIsVisible() {
        softAssert.assertEquals(loginPage.isLogoVisible(), true,
                "Logo is not visible.");
    }

    public void validateEmailFieldAppearance() {
        softAssert.assertEquals(loginPage.isEmailLegendVisible(), true,
                "Email legend is not visible.");
        softAssert.assertEquals(loginPage.getEmailLegendText(), "Email",
                "Email legend is incorrect.");
        softAssert.assertEquals(loginPage.getEmailHintText(), "Email",
                "Email hint is incorrect.");
    }

    public void validatePasswordFieldAppearance() {
        softAssert.assertEquals(loginPage.isPasswordLegendVisible(), true,
                "Password legend is not visible.");
        softAssert.assertEquals(loginPage.getPasswordLegendText(), "Password",
                "Password legend is incorrect.");
        softAssert.assertEquals(loginPage.getPasswordHintText(), "Password",
                "Password hint is incorrect.");
    }

    public void validateLoginButtonText() {
        softAssert.assertEquals(loginPage.getLoginButtonText(), "Log in",
                "Login button text is incorrect.");
    }

    public void validateForgotYourPasswordText() {
        softAssert.assertEquals(loginPage.getForgetYourPasswordText(), "Forgot your password?",
                "Password reset link text is incorrect.");
    }

    public void validateAppStoreBadgeIsVisible() {
        softAssert.assertEquals(loginPage.isAppStoreBadgeVisible(), true,
                "App Store Badge is not visible.");
    }

    public void validatePlayStoreBadgeIsVisible() {
        softAssert.assertEquals(loginPage.isPlayStoreBadgeVisible(), true,
                "Play Store Badge is not visible.");
    }

    public void validateCreateAnAccountText(String expectedText) {
        softAssert.assertEquals(loginPage.getCreateAnAccountLblText(), expectedText,
                "Create an account text is incorrect.");
    }

    public void validateCookiesDescription(String expectedText) {
        String actualText = loginPage.getCookiesDescriptionText();
        softAssert.assertTrue(actualText.matches(expectedText),
                "Actual and expected values do not match. " +
                        "\nExpected : " + expectedText +
                        "\nActual : " + actualText);
    }

    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    public void validateErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    public void clickForgotYourPassword() {
        loginPage.clickForgetYourPasswordLink();
    }

    public void validateEmailFieldText(String expectedEmail) {
        softAssert.assertEquals(loginPage.getEmailFieldText(), expectedEmail,
                "Email field value is incorrect.");
    }

    public void clickAppsStoreLink() {
        loginPage.clickAppsStoreLink();
    }

    public void clickPlayStoreLink() {
        loginPage.clickPlayStoreLink();
    }

    public void clickContactUsLink() {
        loginPage.clickContactUsLink();
        Object[] openedTabs = driver.getWindowHandles().toArray();
        driver.switchTo().window(openedTabs[openedTabs.length - 1].toString());
    }
}
