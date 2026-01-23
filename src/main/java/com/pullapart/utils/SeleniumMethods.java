package com.pullapart.utils;

import com.pullapart.helper.Waits;
import com.pullapart.pages.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumMethods {

    private WebDriver driver;
    private Waits wait;

    public SeleniumMethods(WebDriver driver, Waits wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selClickBy(By byElemLocator) {
        wait.waitForVisibility(byElemLocator);
        wait.waitForClickable(byElemLocator);
        driver.findElement(byElemLocator).click();
    }

    public void clickBy(By byElemLocator) {
        wait.waitForClickable(byElemLocator);
        driver.findElement(byElemLocator).click();
    }

    public void selClearFieldBy(By byElemLocator) {
        wait.waitForVisibility(byElemLocator);
        driver.findElement(byElemLocator).clear();
    }

    public void selSendKeysBy(By byElemLocator, String inputStr) {
        wait.waitForVisibility(byElemLocator);
        driver.findElement(byElemLocator).sendKeys(inputStr);
    }

    public WebElement getWebElement(By byElemLocator) {
        wait.waitForVisibility(byElemLocator);
        return driver.findElement(byElemLocator);
    }

    public String getText(By byElemLocator) {
        wait.waitForVisibility(byElemLocator);
        return driver.findElement(byElemLocator).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void actionsMoveToElementBy(By byElemLocator) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(byElemLocator)).perform();
    }

    public void actionsMoveToElementClickBy(By byElemLocator) {
        wait.waitForVisibility(byElemLocator);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(byElemLocator)).click().build().perform();
    }

    public void jsClick(By byElemLocator) {
        wait.waitForVisibility(byElemLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(byElemLocator));
    }

    public void jsScroll(By byElemLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(byElemLocator));
    }

    public void jsWaitForPageLoadComplete() {
        ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
    }

    public void jsWaitForPageLoadCompleteV2() {
        JavascriptExecutor j = (JavascriptExecutor)driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")){
            System.out.println("Page has loaded");
        }
    }

    public int findTotalElementCount(By elemLocator) {
        wait.waitForPresence(elemLocator);
        wait.waitForVisibility(elemLocator);
        return driver.findElements(elemLocator).size();
    }

    public boolean isPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isVisible(By locator) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
