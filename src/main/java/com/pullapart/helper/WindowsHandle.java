package com.pullapart.helper;

import com.pullapart.pagebase.PageBase;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;

public class WindowsHandle extends PageBase {
    public WindowsHandle(WebDriver driver) {
        super(driver);
    }

    public void switchToNewWindow() throws InterruptedException {
        Iterator<String> wh = driver.getWindowHandles().iterator();
        String mainWinow = wh.next();
        String newWinow = wh.next();
        driver.switchTo().window(newWinow);
    }

    public void switchToMainWindow() throws InterruptedException {
        Iterator<String> wh = driver.getWindowHandles().iterator();
        String mainWin = wh.next();
        driver.switchTo().window(mainWin);
    }
}
