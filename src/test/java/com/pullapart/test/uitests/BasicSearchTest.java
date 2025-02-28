package com.pullapart.test.uitests;

import com.pullapart.test.testbase.TestBase;
import org.testng.annotations.Test;

public class BasicSearchTest extends TestBase {

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

    @Test(groups = {"basicsearch"}, dataProvider = "dataProvider", description = "test to show test data being passed " +
            "in via testNG data provider")
    public void performBasicSearchInGeorgiaWithDataProvider(String location, String make, String model) throws InterruptedException {
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
