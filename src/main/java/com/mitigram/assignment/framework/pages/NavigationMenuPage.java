package com.mitigram.assignment.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenuPage {
    private final WebDriver driver;
    @FindBy(css = "ul.g-toplevel")
    private WebElement navigationMenu;
    @FindBy(xpath = "//span[@class='g-menu-item-title' and text()='Solutions']")
    private WebElement solutionsMenuItem;
    @FindBy(className = "g-active")
    private WebElement solutionsMenuDropDown;

    public NavigationMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void moveMousePointerToSolutionsMenuItem() {
        Actions actions = new Actions(driver);
        actions.moveToElement(solutionsMenuItem).perform();
    }

    public boolean isNavigationMenuVisibleInViewport() {
        String script =
                "var elem = arguments[0],                           " +
                        "  box = elem.getBoundingClientRect(),      " +
                        "  cx = box.left + box.width / 2,           " +
                        "  cy = box.top + box.height / 2,           " +
                        "  efp = document.elementFromPoint(cx, cy); " +
                        "for (; elem; elem = elem.parentElement) {  " +
                        "  if (elem === efp) return true;           " +
                        "}                                          " +
                        "return false;                              ";

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (boolean) jsExecutor.executeScript(script, navigationMenu);
    }
}
