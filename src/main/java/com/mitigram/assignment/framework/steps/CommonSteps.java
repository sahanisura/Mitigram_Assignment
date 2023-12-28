package com.mitigram.assignment.framework.steps;

import com.mitigram.assignment.framework.managers.ConfigurationManager;
import com.mitigram.assignment.framework.pages.NavigationMenuPage;
import com.mitigram.assignment.framework.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static com.mitigram.assignment.framework.utils.TestContext.*;

public class CommonSteps {
    private final SoftAssert softAssert;
    private final WebDriver driver;

    public CommonSteps() {
        this.driver = getDriver();
        this.softAssert = getSoftAssert();
    }

    public void navigateToPage(String pageName) {
        if (pageName.equalsIgnoreCase("home")) {
            driver.get(ConfigurationManager.getProperty("SITE_URL"));
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
