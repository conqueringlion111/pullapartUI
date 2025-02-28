package com.pullapart.pages;

import com.pullapart.locators.FAQPageLocators;
import com.pullapart.pagebase.PageBase;
import com.pullapart.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FAQPage extends PageBase {

    public FAQPage(WebDriver driver) {
        super(driver);
    }


    public FAQPage verifySuccessfulNavigationToFAQPage() {
        SeleniumMethods sel = new SeleniumMethods(driver);
        boolean navigationSuccess = sel.isElementPresent(FAQPageLocators.FAQ_DIV_XPATH);
        Assert.assertTrue(navigationSuccess, "navigation to FAQ page not successful");
        return new FAQPage(driver);
    }
}
