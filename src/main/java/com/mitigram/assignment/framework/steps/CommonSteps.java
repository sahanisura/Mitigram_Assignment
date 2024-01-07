package com.mitigram.assignment.framework.steps;

import com.mitigram.assignment.framework.pages.NavigationMenuPage;
import com.mitigram.assignment.framework.pages.HomePage;
import com.mitigram.assignment.framework.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;

public class CommonSteps extends StepBase {

    public void navigateToPage(String pageName) {
        if (pageName.equalsIgnoreCase("home")) {
            driver.get(Constants.SITE_URl);
            acceptCookies();
        } else if (pageName.equalsIgnoreCase("login")) {
            HomePage homePage = new HomePage(driver);
            homePage.clickLoginButton();
        } else if (pageName.equalsIgnoreCase("careers")) {
            HomePage homePage = new HomePage(driver);
            homePage.clickCareersLink();
        }
    }

    public void validateNavigationMenuIsVisible() {
        NavigationMenuPage navigationMenuPage = new NavigationMenuPage(driver);
        softAssert.assertEquals(navigationMenuPage.isNavigationMenuVisibleInViewport(), true,
                "Navigation menu is not visible.");
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void verifyThatTheUserIsOnThePage(String expectedPageLink) {
        softAssert.assertTrue(driver.getCurrentUrl().contains(expectedPageLink),
                "The user is not on the expected page. " +
                        "\nExpected Page link : " + expectedPageLink +
                        "\nActual Page link : \"" + driver.getCurrentUrl());
    }

    public void acceptCookies() {
        HomePage homePage = new HomePage(driver);
        if (homePage.isAcceptCookiesButtonVisible()) {
            homePage.clickAcceptCookies();
        }
    }

    public void scrollPage(int pixels) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }
}
