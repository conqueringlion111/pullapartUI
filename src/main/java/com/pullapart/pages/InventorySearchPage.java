package com.pullapart.pages;

import com.pullapart.locators.InventorySearchPageLocators;
import com.pullapart.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import com.pullapart.pagebase.PageBase;
import org.testng.Assert;

public class InventorySearchPage extends PageBase {
    public InventorySearchPage(WebDriver driver) {
        super(driver);
    }

    SeleniumMethods sel = new SeleniumMethods(driver);

    public InventorySearchPage verifyNavigationToInventorySearchPageSuccessful() {
        boolean navigationSuccessful = sel.isElementPresent(InventorySearchPageLocators.INVENTORY_SEARCH_PAGE_CSS);
        Assert.assertTrue(navigationSuccessful, "navigation to Inventory Search Page not successful");
        return new InventorySearchPage(driver);
    }

    public InventorySearchPage verifySearchSuccessful(String make, String model) {
        //see if search actually returned results - "exact match"
        boolean searchResults = sel.isElementPresent(InventorySearchPageLocators.EXACT_MATCH_LABEL_XPATH);
        if (searchResults) {
            //get to total result count
            int totalResult = sel.findTotalElementCount(InventorySearchPageLocators.SEARCH_RESULT_ROLES_XPATH);
            for (int i = 1; i <= totalResult; ++i) {
                String index = String.valueOf(i);
                Assert.assertTrue(sel.isElementPresent(InventorySearchPageLocators.findSearchedValue(index, make)));
                Assert.assertTrue(sel.isElementPresent(InventorySearchPageLocators.findSearchedValue(index, model)));
            }
        } else {
            boolean navigationSuccessful = sel.isElementPresent(InventorySearchPageLocators.INVENTORY_SEARCH_PAGE_CSS);
            Assert.assertTrue(navigationSuccessful, "navigation to Inventory Search Page not successful");
        }
        return new InventorySearchPage(driver);
    }
}
