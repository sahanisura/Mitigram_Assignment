package com.mitigram.assignment.framework.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mitigram.assignment.framework.steps.CommonSteps;
import com.mitigram.assignment.framework.steps.ForgotPasswordPageSteps;
import com.mitigram.assignment.framework.steps.LoginPageSteps;

public class LoginFlowTests extends TestBase {
    private CommonSteps commonSteps;
    private LoginPageSteps loginPageSteps;
    private ForgotPasswordPageSteps forgotPasswordPageSteps;

    @BeforeMethod(dependsOnMethods = "testBaseBeforeMethod")
    public void beforeMethod() {
        commonSteps = new CommonSteps();
        loginPageSteps = new LoginPageSteps();
        forgotPasswordPageSteps = new ForgotPasswordPageSteps();
    }

    @Test
    public void testValidateLoginPageElements() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.validateLogoIsVisible();
        loginPageSteps.validateEmailFieldAppearance();
        loginPageSteps.validatePasswordFieldAppearance();
        loginPageSteps.validateLoginButtonText();
        loginPageSteps.validateForgotYourPasswordText();
        loginPageSteps.validateAppStoreLinkIsVisible();
        loginPageSteps.validatePlayStoreLinkIsVisible();
        loginPageSteps.validateCreateAnAccountText("Would you like to create an account? Contact us");
        loginPageSteps.validateCookiesDescription("We use cookies to give you the best experience on our site.\n" +
                "Cookies are files stored in your browser and are used by most websites to help personalise visitors web experience.\n" +
                "By logging in, you are accepting cookies on mitigram.com.");
        assertAll();
    }

    @Test
    public void testLoginWithValidEmailAndValidPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterEmail("validEmail@gmail.com");
        loginPageSteps.enterPassword("validPassword");
        loginPageSteps.clickLoginButton();
        //Validation should be added to verify the successful login message or page.
        //assertAll();
    }

    @Test
    public void testLoginWithValidEmailAndInvalidPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterEmail("validEmail@gmail.com");
        loginPageSteps.enterPassword("invalidPassword");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("Invalid login attempt.");
        assertAll();
    }

    @Test
    public void testLoginWithValidEmailAndWithoutPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterEmail("validEmail@gmail.com");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("Password is required");
        assertAll();
    }

    @Test
    public void testLoginWithInvalidEmailAndValidPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterEmail("invalidEmail@gmail.com");
        loginPageSteps.enterPassword("validPassword");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("Invalid login attempt.");
        assertAll();
    }

    @Test
    public void testLoginWithInvalidEmailAndInvalidPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterEmail("invalidEmail@gmail.com");
        loginPageSteps.enterPassword("invalidPassword");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("Invalid login attempt.");
        assertAll();
    }

    @Test
    public void testLoginWithInvalidEmailAndWithoutPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterEmail("invalidEmail@gmail.com");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("Password is required");
        assertAll();
    }

    @Test
    public void testLoginWithoutEmailAndValidPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterPassword("validPassword");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("Email is required The Email field is not a valid e-mail address.");
        assertAll();
    }

    @Test
    public void testLoginWithoutEmailAndInvalidPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterPassword("invalidPassword");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("Email is required The Email field is not a valid e-mail address.");
        assertAll();
    }

    @Test
    public void testLoginWithoutEmailAndWithoutPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("Email is required The Email field is not a valid e-mail address.");
        assertAll();
    }

    @Test
    public void testLoginWithInvalidEmailFormatAndValidPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterEmail("invalidFormat");
        loginPageSteps.enterPassword("validPassword");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("The Email field is not a valid e-mail address.");
        assertAll();
    }

    @Test
    public void testLoginWithInvalidEmailFormatAndInvalidPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterEmail("invalidFormat");
        loginPageSteps.enterPassword("invalidPassword");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("The Email field is not a valid e-mail address.");
        assertAll();
    }

    @Test
    public void testLoginWithInvalidEmailFormatAndWithoutPassword() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.enterEmail("invalidFormat");
        loginPageSteps.clickLoginButton();
        loginPageSteps.validateErrorMessage("The Email field is not a valid e-mail address.");
        assertAll();
    }

    @Test
    public void testResetPasswordWithValidEmailAndGoBackToLoginPage() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.clickForgotYourPassword();
        forgotPasswordPageSteps.enterEmail("validEmail@gmail.com");
        forgotPasswordPageSteps.clickEmailLinkButton();
        forgotPasswordPageSteps.validateHeaderText("Forgot Password Confirmation");
        forgotPasswordPageSteps.validateParagraphText("Please check your email to reset your password. Back to Login");
        forgotPasswordPageSteps.clickBackToLoginLink();
        commonSteps.verifyThatTheUserIsOnThePage("https://marketplace.mitigram.com/Account/Login");
        loginPageSteps.validateEmailFieldText("validEmail@gmail.com");
        assertAll();
        /* If there is a way to retrieve the new password,
        the test should continue by logging in using the new password. */
    }

    @Test
    public void testResetPasswordWithoutEmail() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.clickForgotYourPassword();
        forgotPasswordPageSteps.clickEmailLinkButton();
        forgotPasswordPageSteps.validateEmailFieldValidationMessage(
                "Please fill out this field.");
        assertAll();
    }

    @Test
    public void testResetPasswordWithInvalidEmailFormat() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.clickForgotYourPassword();
        forgotPasswordPageSteps.enterEmail("invalidFormat");
        forgotPasswordPageSteps.clickEmailLinkButton();
        forgotPasswordPageSteps.validateEmailFieldValidationMessage(
                "Please include an '@' in the email address. 'invalidFormat' is missing an '@'.");
        forgotPasswordPageSteps.clearEmail();
        forgotPasswordPageSteps.enterEmail("invalidFormat@");
        forgotPasswordPageSteps.clickEmailLinkButton();
        forgotPasswordPageSteps.validateEmailFieldValidationMessage(
                "Please enter a part following '@'. 'invalidFormat@' is incomplete.");
        assertAll();
    }

    @Test
    public void testClickAlreadyHaveAnAccountFromResetPasswordPage() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.clickForgotYourPassword();
        forgotPasswordPageSteps.clickAlreadyHaveAnAccount();
        commonSteps.verifyThatTheUserIsOnThePage("https://marketplace.mitigram.com/Account/Login");
        assertAll();
    }

    @Test
    public void testValidateAppsStoreLinkRedirectsToTheAppsStore() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.clickAppsStoreLink();
        commonSteps.verifyThatTheUserIsOnThePage("https://apps.apple.com/us/app/mitigram");
        assertAll();
    }

    @Test
    public void testValidatePlayStoreLinkRedirectsToThePlayStore() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.clickPlayStoreLink();
        commonSteps.verifyThatTheUserIsOnThePage("https://play.google.com/store/apps/details?id=com.mitigram.marketplace");
        assertAll();
    }

    @Test
    public void testValidateContactUsLinkRedirectsToTheContactUsPage() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("login");
        loginPageSteps.clickContactUsLink();
        commonSteps.verifyThatTheUserIsOnThePage("https://mitigram.com/#contact");
        assertAll();
    }
}
