package com.pullapart.helper;

import com.pullapart.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private WebDriver driver;
    private WebDriverWait wait;

    public Waits(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    final Duration maxWait = Duration.ofSeconds(5);

    public void waitForTextPresentInElementBy(By byLocator, String textPresense) {
        WebDriverWait wait = new WebDriverWait(driver, maxWait);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(byLocator), textPresense));
    }

    public void waitForVisibilityOfElementBy(By byLocator) {
        WebDriverWait wait = new WebDriverWait(driver, maxWait);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(byLocator)));
    }


    public void waitForPresenseOfElementBy(By byLocator) {
        WebDriverWait wait = new WebDriverWait(driver, maxWait);
        wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    public void waitForInvisibilityOfWElementBy(By byLocator) {
        WebDriverWait wait = new WebDriverWait(driver, maxWait);
        Boolean bool = wait.until(ExpectedConditions.invisibilityOf(driver.findElement(byLocator)));
    }

    public void waitForElementClickable(WebElement webElemLoc) {
        WebDriverWait wait = new WebDriverWait(driver, maxWait);
        wait.until(ExpectedConditions.elementToBeClickable(webElemLoc));
    }

    public void waitForElementClickableBy(By byElemLoc) {
        WebDriverWait wait = new WebDriverWait(driver, maxWait);
        wait.until(ExpectedConditions.elementToBeClickable(byElemLoc));
    }
}
