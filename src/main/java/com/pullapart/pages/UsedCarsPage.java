package com.pullapart.pages;

import com.pullapart.locators.UsedCarsPageLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UsedCarsPage extends PageBase {

    public UsedCarsPage(WebDriver driver) {
        super(driver);
    }

    public UsedCarsPage verifyNavigationToUsedCarPageSuccessful() {
        boolean navigation = sel.isPresent(UsedCarsPageLocators.WHERE_WE_SELL_USED_CARS_H2_XPATH);
        Assert.assertTrue(navigation, "navigation to Used Cars Page not successful");
        return new UsedCarsPage(driver);
    }

    public UsedCarsPage enterZipCode(String zipCode) {
        sel.selSendKeysBy(UsedCarsPageLocators.ENTER_ZIP_CODE_XPAH, zipCode);
        return this;
    }

    public UsedCarsPage selectSubmitButton() {
        sel.selClickBy(UsedCarsPageLocators.SUBMIT_BUTTON_XPATH);
        return this;
    }

    public UsedCarsPage verifySearchResultsBannerApears() throws InterruptedException {
        Assert.assertTrue(sel.isPresent(UsedCarsPageLocators.RESULTS_DISPLAY_BANNER_WHERE_WE_SELL), "Search result " +
                "banner was not displayed");
        return this;
    }

    public UsedCarsPage verifySearchResultsLocationsDisplay() {
        Assert.assertTrue(sel.isPresent(UsedCarsPageLocators.USED_CARS_LOCATION_RESULTS));
        return this;
    }

    public UsedCarsPage verifySearchResultsLocationsReturned() {
        wait.waitForVisibility(UsedCarsPageLocators.USED_CARS_LOCATION_RESULTS);
        int searchResultCount = sel.findTotalElementCount(UsedCarsPageLocators.USED_CARS_LOCATION_RESULTS);
        Assert.assertTrue(searchResultCount > 0);
        return this;
    }
}
