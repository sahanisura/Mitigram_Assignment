package com.mitigram.assignment.framework.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mitigram.assignment.framework.steps.CareersPageSteps;
import com.mitigram.assignment.framework.steps.CommonSteps;

import java.util.Map;

public class CareersPageTests extends TestBase {
    private CommonSteps commonSteps;
    private CareersPageSteps careersPageSteps;

    @BeforeMethod(dependsOnMethods = "testBaseBeforeMethod")
    public void beforeMethod() {
        commonSteps = new CommonSteps();
        careersPageSteps = new CareersPageSteps();
    }

    @Test
    public void testValidateHeaderSection() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("careers");
        commonSteps.validateNavigationMenuIsVisible();
        careersPageSteps.validateHeadingText("Make Mitigram your next move");
        careersPageSteps.validateParagraphText("Mitigram is one of the most exciting FinTech companies " +
                "in Europe. Our strong growth, combined with a client list of the world's leading corporates and banks, " +
                "means we can offer exciting opportunities for anyone who joins us at this stage.");
        assertAll();
    }

    /* As tc1ValidateHeaderSection, tests should be added to validate features section, utility section
    and above section. But it's better to validate static content/text at lower layers of the test pyramid */

    @Test
    public void testValidateEngineeringPositionsFiltering() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("careers");
        careersPageSteps.click0penPositionsButton();
        careersPageSteps.filterOpenPositionsBy("Engineering");
        careersPageSteps.validateFilteredPositions(Map.of(
                "QA Automation Engineer", "Stockholm",
                "Back-end Software Engineer", "Stockholm",
                "Front-end Software Engineer", "Stockholm"));
        assertAll();
    }

    @Test
    public void testValidateQaAutomationEngineerPositionAndApply() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("careers");
        careersPageSteps.click0penPositionsButton();
        careersPageSteps.filterOpenPositionsBy("Engineering");
        careersPageSteps.clickPosition("QA Automation Engineer");
        careersPageSteps.validateJobSummary("We are looking for a QA Automation Engineer to " +
                "join our team on our .*");
        careersPageSteps.clickLearnMoreButton();
        commonSteps.verifyThatTheUserIsOnThePage("https://www.mitigram.com/images/ads/QA-Automation-Engineer.pdf");
        commonSteps.navigateBack();
        careersPageSteps.filterOpenPositionsBy("Engineering");
        careersPageSteps.clickPosition("QA Automation Engineer");
        careersPageSteps.clickApplyForThisPositionButton();
        commonSteps.verifyThatTheUserIsOnThePage("https://www.mitigram.com/contact");
        assertAll();
    }

    @Test
    public void testValidateLegalPositionsFilteringAndLegalCounselPositionAndApply() {
        commonSteps.navigateToPage("home");
        commonSteps.navigateToPage("careers");
        careersPageSteps.click0penPositionsButton();
        careersPageSteps.filterOpenPositionsBy("Legal");
        careersPageSteps.validateFilteredPositions(Map.of(
                "Legal Counsel", "Stockholm"));
        careersPageSteps.clickPosition("Legal Counsel");
        careersPageSteps.validateJobSummary("This role, based in Stockholm, will lead all our " +
                "legal efforts, in both internal or external matters.");
        careersPageSteps.clickLearnMoreButton();
        commonSteps.verifyThatTheUserIsOnThePage("https://www.mitigram.com/images/ads/Legal_Counsel.pdf");
        commonSteps.navigateBack();
        careersPageSteps.filterOpenPositionsBy("Legal");
        careersPageSteps.clickPosition("Legal Counsel");
        careersPageSteps.clickApplyForThisPositionButton();
        commonSteps.verifyThatTheUserIsOnThePage("https://www.mitigram.com/contact");
        assertAll();
    }
}
