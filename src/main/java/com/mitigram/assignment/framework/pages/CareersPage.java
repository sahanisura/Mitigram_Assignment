package com.mitigram.assignment.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CareersPage extends PageBase {
    private String clickedPositionName;
    @FindBy(css = "#g-header h1")
    private WebElement heading;
    @FindBy(css = "#g-header p")
    private WebElement paragraph;
    @FindBy(linkText = "Open positions")
    private WebElement openPositionsBtn;
    @FindBy(css = "#faq ul li a")
    private List<WebElement> filterCriteriaList;
    @FindBy(className = "tm-wrapper")
    private List<WebElement> allOpenPositions;

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public String getParagraphText() {
        return paragraph.getText();
    }

    public void click0penPositionsButton() {
        openPositionsBtn.click();
    }

    public void filterOpenPositionsBy(String filterCriterion) {
        Optional<WebElement> filterCriterionElement = filterCriteriaList.stream()
                .filter(webElement -> webElement.getText().equalsIgnoreCase(filterCriterion))
                .findFirst();

        filterCriterionElement.ifPresentOrElse(WebElement::click,
                () -> {
                    throw new NoSuchElementException("Filter Criterion with name '"
                            + filterCriterion + "' not found");
                });

        waitUntilFilteringIsCompleted(filterCriterion);
    }

    public Map<String, String> getVisiblePositionsAndLocations() {
        return allOpenPositions.stream()
                .filter(webElement -> !webElement.getAttribute("style").contains("display: none;"))
                .collect(Collectors.toMap(webElement -> webElement.findElement(By.tagName("a")).getText(),
                        webElement -> webElement.findElement(By.className("tm-subtitle")).getText()));
    }

    public void clickPosition(String position) {
        getPosition(position).findElement(By.className("jl-accordion-title")).click();
        clickedPositionName = position;
    }

    public String getJobSummaryText() {
        checkClickedPositionNameNotNull();
        return waitUntilVisibilityOfElement(getPosition(clickedPositionName), By.tagName("p")).getText();
    }

    public void clickLearnMoreButton() {
        checkClickedPositionNameNotNull();
        getPosition(clickedPositionName).findElement(By.linkText("Learn more")).click();
    }

    public void clickApplyForThisPositionButton() {
        checkClickedPositionNameNotNull();
        getPosition(clickedPositionName).findElement(By.linkText("Apply for this position")).click();
    }

    private void checkClickedPositionNameNotNull() {
        if (clickedPositionName == null) {
            throw new IllegalStateException("clickedPositionName is null. Click on the position before you perform this action");
        }
    }

    private WebElement getPosition(String positionName) {
        Optional<WebElement> actualPosition = allOpenPositions.stream().filter(webElement ->
                        webElement.findElement(By.className("jl-accordion-title")).getText().equalsIgnoreCase(positionName))
                .findFirst();

        if (actualPosition.isPresent()) {
            return actualPosition.get();
        } else {
            throw new NoSuchElementException("Position with name '"
                    + positionName + "' not found");
        }
    }

    private void waitUntilFilteringIsCompleted(String filterCriterion) {
        List<WebElement> positionsNeedToBeInvisible = allOpenPositions.stream()
                .filter(webElement -> !webElement.getAttribute("data-tag").equalsIgnoreCase(filterCriterion))
                .toList();

        waitUntilInvisibilityOfAllElements(positionsNeedToBeInvisible);
    }
}
