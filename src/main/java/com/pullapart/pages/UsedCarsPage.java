package com.pullapart.pages;

import com.pullapart.locators.UsedCarsPageLocators;
import com.pullapart.pagebase.PageBase;
import com.pullapart.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UsedCarsPage extends PageBase {

    public UsedCarsPage(WebDriver driver) {
        super(driver);
    }

    public UsedCarsPage verifyNavigationToUsedCarPageSuccessful() {
        SeleniumMethods sel = new SeleniumMethods(driver);
        boolean navigation = sel.isElementPresent(UsedCarsPageLocators.WHERE_WE_SELL_USED_CARS_H2_XPATH);
        Assert.assertTrue(navigation, "navigation to Used Cars Page not successful");
        return new UsedCarsPage(driver);
    }
}
