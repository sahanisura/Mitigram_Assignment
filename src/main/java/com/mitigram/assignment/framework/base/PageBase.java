package com.mitigram.assignment.framework.base;

import com.mitigram.assignment.framework.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageBase {
    protected final WebDriverWait wait;
    protected final WebDriver driver;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIMEOUT));
        this.driver = driver;
    }

    protected WebElement waitUntilVisibilityOfElement(WebElement webElement, By locator) {
        Wait<WebDriver> wait1 = new FluentWait<>(driver);
        wait1.until(ExpectedConditions.visibilityOf(webElement));
        return wait.until(ExpectedConditions.visibilityOf(webElement.findElement(locator)));
    }

    protected WebElement waitUntilVisibilityOfElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitUntilInvisibilityOfAllElements(List<WebElement> webElementList) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(webElementList));
    }

    protected WebElement fluentWaitPresenceOfElement(By locator) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(TimeoutException.class);

        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected Object executeJavaScript(String script, WebElement webElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(script, webElement);
    }
}
