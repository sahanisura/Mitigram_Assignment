package com.mitigram.assignment.framework.steps;

import com.mitigram.assignment.framework.pages.NavigationMenuPage;
import com.mitigram.assignment.framework.pages.HomePage;
import com.mitigram.assignment.framework.utils.Constants;

public class CommonSteps extends StepBase {

    public void navigateToPage(String pageName) {
        if (pageName.equalsIgnoreCase("home")) {
            driver.get(Constants.SITE_URl);
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
}
