package com.pullapart.uitests;

import com.pullapart.testbase.TestBase;
import org.testng.annotations.Test;

public class BasicSearch extends TestBase {

    @Test(groups = {"basicsearch"}, description = "test to perform basic search")
    public void performBasicSearchInGeorgia() throws InterruptedException {
        String location = "Atlanta North";
        String make = "INFINITI";
        String model = "Q45";
        homepage.clickOnSelectLocation()
                .fillInSearchField(location)
                .selectSearchResult(location)
                .clickOnSelectMake()
                .fillInSearchField(make)
                .selectSearchResult(make)
                .clickOnSelectModel()
                .fillInSearchField(model)
                .selectSearchResult(model)
                .clickOnSearchButton()
                .verifySearchSuccessful(make, model);
    }
}
