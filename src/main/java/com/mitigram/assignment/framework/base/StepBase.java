package com.mitigram.assignment.framework.base;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static com.mitigram.assignment.framework.utils.TestContext.getDriver;
import static com.mitigram.assignment.framework.utils.TestContext.getSoftAssert;

public class StepBase {
    protected final SoftAssert softAssert;
    protected final WebDriver driver;

    public StepBase() {
        this.softAssert = getSoftAssert();
        this.driver = getDriver();
        initPages();
    }

    protected void initPages() {
    }
}
