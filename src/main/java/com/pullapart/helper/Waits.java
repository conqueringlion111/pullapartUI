package com.pullapart.helper;

import com.pullapart.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private final WebDriver driver;
    private final Duration maxWait = Duration.ofSeconds(5);

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForVisibility(By locator) {
        return new WebDriverWait(driver, maxWait)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForPresence(By locator) {
        return new WebDriverWait(driver, maxWait)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForInvisibility(By locator) {
        return new WebDriverWait(driver, maxWait)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean waitForTextPresent(By locator, String text) {
        return new WebDriverWait(driver, maxWait)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public WebElement waitForClickable(By locator) {
        return new WebDriverWait(driver, maxWait)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}
