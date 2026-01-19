package com.pullapart.pages;

import com.pullapart.locators.InventorySearchPageLocators;
import com.pullapart.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InventorySearchPage extends PageBase {
    public InventorySearchPage(WebDriver driver) {
        super(driver);
    }

    public InventorySearchPage verifyNavigationToInventorySearchPageSuccessful() {
        boolean navigationSuccessful = sel.isPresent(InventorySearchPageLocators.INVENTORY_SEARCH_PAGE_CSS);
        Assert.assertTrue(navigationSuccessful, "navigation to Inventory Search Page not successful");
        return new InventorySearchPage(driver);
    }

    public InventorySearchPage verifySearchSuccessful(String make, String model) {
        //see if search failed
        boolean searchFalse = sel.isPresent(InventorySearchPageLocators.SORRY_WE_COULDNT_FIND);

        if(searchFalse) {
            boolean navigationSuccessful = sel.isPresent(InventorySearchPageLocators.INVENTORY_SEARCH_PAGE_CSS);
            Assert.assertTrue(navigationSuccessful, "navigation to Inventory Search Page not successful");
        } else {
            //get to total result count
            int totalResult = sel.findTotalElementCount(InventorySearchPageLocators.SEARCH_RESULT_ROLES_XPATH);
            for (int i = 1; i <= totalResult; ++i) {
                String index = String.valueOf(i);
                Assert.assertTrue(sel.isPresent(InventorySearchPageLocators.findSearchedValue(index, make)));
                Assert.assertTrue(sel.isPresent(InventorySearchPageLocators.findSearchedValue(index, model)));
            }
        }

        return new InventorySearchPage(driver);
    }
}
