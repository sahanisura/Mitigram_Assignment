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
    @FindBy(css = "#app-store-badges [alt=\"Download on the App Store\"]")
    private WebElement appStoreLnk;
    @FindBy(css = "#app-store-badges [alt=\"Get it on Google Play\"]")
    private WebElement playStoreLnk;
    @FindBy(className = "registration-call")
    private WebElement createAnAccountLbl;
    @FindBy(className = "notifications")
    private WebElement cookiesDescriptionLbl;
    @FindBy(linkText = "Contact us")
    private WebElement contactUsLnk;

    //Use 'By' locators for dynamically loaded elements
    private final By errorLbl = By.className("noty_body");

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

    public boolean isAppStoreLinkVisible() {
        return appStoreLnk.isDisplayed();
    }

    public boolean isPlayStoreLinkVisible() {
        return playStoreLnk.isDisplayed();
    }

    public String getCreateAnAccountLblText() {
        return createAnAccountLbl.getText();
    }

    public String getCookiesDescriptionText() {
        return cookiesDescriptionLbl.getText();
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
        return waitUntilElementIsLocatedAndDisplayed(errorLbl).getText();
    }

    public String getEmailFieldText() {
        return emailTxt.getAttribute("value");
    }

    public void clickAppsStoreLink() {
        appStoreLnk.click();
    }

    public void clickPlayStoreLink() {
        playStoreLnk.click();
    }

    public void clickContactUsLink() {
        contactUsLnk.click();
    }
}
