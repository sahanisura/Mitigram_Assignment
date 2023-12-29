package com.mitigram.assignment.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    @FindBy(className = "logo")
    private WebElement logo;
    @FindBy(id = "Email")
    private WebElement emailTxt;
    @FindBy(id = "Password")
    private WebElement passwordTxt;
    @FindBy(id = "loginBtn")
    private WebElement loginBtn;
    @FindBy(linkText = "Forgot your password?")
    private WebElement forgetYourPasswordLnk;
    @FindBy(className = "noty_body")
    private WebElement errorLbl;
    @FindBy(css = "#app-store-badges [alt=\"Download on the App Store\"]")
    private WebElement appStoreBadge;
    @FindBy(css = "#app-store-badges [alt=\"Get it on Google Play\"]")
    private WebElement playStoreBadge;
    @FindBy(className = "registration-call")
    private WebElement createAnAccountLbl;
    @FindBy(className = "notifications")
    private WebElement cookiesDescription;
    @FindBy(linkText = "Contact us")
    private WebElement contactUs;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoVisible() {
        return logo.isDisplayed();
    }

    public boolean isEmailLegendVisible() {
        return emailTxt.findElement(By.xpath("preceding-sibling::legend"))
                .isDisplayed();
    }

    public String getEmailLegendText() {
        return emailTxt.findElement(By.xpath("preceding-sibling::legend"))
                .getText();
    }

    public String getEmailHintText() {
        return emailTxt.getAttribute("placeholder");
    }

    public boolean isPasswordLegendVisible() {
        return passwordTxt.findElement(By.xpath("preceding-sibling::legend"))
                .isDisplayed();
    }

    public String getPasswordLegendText() {
        return passwordTxt.findElement(By.xpath("preceding-sibling::legend"))
                .getText();
    }

    public String getPasswordHintText() {
        return passwordTxt.getAttribute("placeholder");
    }

    public String getLoginButtonText() {
        return loginBtn.getText();
    }

    public String getForgetYourPasswordText() {
        return forgetYourPasswordLnk.getText();
    }

    public boolean isAppStoreBadgeVisible() {
        return appStoreBadge.isDisplayed();
    }

    public boolean isPlayStoreBadgeVisible() {
        return playStoreBadge.isDisplayed();
    }

    public String getCreateAnAccountLblText() {
        return createAnAccountLbl.getText();
    }

    public String getCookiesDescriptionText() {
        return cookiesDescription.getText();
    }

    public void enterEmail(String email) {
        emailTxt.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordTxt.sendKeys(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public void clickForgetYourPasswordLink() {
        forgetYourPasswordLnk.click();
    }

    public String getErrorMessage() {
        return waitUntilVisibilityOfElement(errorLbl).getText();
    }

    public String getEmailFieldText() {
        return emailTxt.getAttribute("value");
    }

    public void clickAppsStoreLink() {
        appStoreBadge.click();
    }

    public void clickPlayStoreLink() {
        playStoreBadge.click();
    }

    public void clickContactUsLink() {
        contactUs.click();
    }
}
