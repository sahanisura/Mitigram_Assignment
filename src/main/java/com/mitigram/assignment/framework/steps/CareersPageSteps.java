package com.mitigram.assignment.framework.steps;

import com.mitigram.assignment.framework.pages.CareersPage;
import org.testng.asserts.SoftAssert;

import static com.mitigram.assignment.framework.utils.TestContext.*;

import java.util.Map;

public class CareersPageSteps {
    private final SoftAssert softAssert;
    protected CareersPage careersPage;

    public CareersPageSteps() {
        this.softAssert = getSoftAssert();
        initPages();
    }

    protected void initPages() {
        careersPage = new CareersPage(getDriver());
    }

    public void validateHeadingText(String expectedHeadingText) {
        String actualHeadingText = careersPage.getHeadingText();
        softAssert.assertEquals(actualHeadingText, expectedHeadingText);
    }

    public void validateParagraphText(String expectedParagraphText) {
        String actualParagraphText = careersPage.getParagraphText();
        softAssert.assertTrue(actualParagraphText.matches(expectedParagraphText),
                "Actual and expected values do not match. " +
                        "\nExpected : " + expectedParagraphText +
                        "\nActual : " + actualParagraphText);
    }

    public void click0penPositionsButton() {
        careersPage.click0penPositionsButton();
    }

    public void filterOpenPositionsBy(String filterCriterion) {
        careersPage.filterOpenPositionsBy(filterCriterion);
    }

    public void validateFilteredPositions(Map<String, String> filteredPositionsAndLocationMap) {
        Map<String, String> visiblePositionsAndLocationsMap = careersPage.getVisiblePositionsAndLocations();

        softAssert.assertEquals(visiblePositionsAndLocationsMap.size(), filteredPositionsAndLocationMap.size(),
                "The expected count of filtered positions does not match the actual count of filtered positions.");

        filteredPositionsAndLocationMap.forEach((key, value) -> {
            softAssert.assertFalse(!visiblePositionsAndLocationsMap.containsKey(key),
                    key + " position is not in the filtered positions.");

            softAssert.assertEquals(visiblePositionsAndLocationsMap.get(key), value,
                    "The expected location of " + key + " position does not match the actual location.");
        });
    }

    public void clickPosition(String position) {
        careersPage.clickPosition(position);
    }

    public void validateJobSummary(String expectedJobSummaryText) {
        String actualJobSummaryText = careersPage.getJobSummaryText();
        softAssert.assertTrue(actualJobSummaryText.matches(expectedJobSummaryText),
                "Actual and expected values do not match. " +
                        "\nExpected : " + expectedJobSummaryText +
                        "\nActual : " + actualJobSummaryText);
    }

    public void clickLearnMoreButton() {
        careersPage.clickLearnMoreButton();
    }

    public void clickApplyForThisPositionButton() {
        careersPage.clickApplyForThisPositionButton();
    }
}
