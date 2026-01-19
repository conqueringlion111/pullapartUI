package com.pullapart.test;

import org.testng.annotations.Test;

public class UsedCarSearch extends TestBase {
    @Test(groups = {"usedcars"}, description = "test to navigate to used cars page and perform a search")
    public void searchUsedCars() throws InterruptedException {
        String zipCode = "30096";
        homepage.navigateToUsedCarsPage()
                .enterZipCode(zipCode)
                .selectSubmitButton()
                .verifySearchResultsBannerApears()
                .verifySearchResultsLocationsDisplay()
                .verifySearchResultsLocationsReturned();
    }
}
