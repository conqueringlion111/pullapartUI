package com.pullapart.pages;

import com.pullapart.locators.HomePageLocators;
import com.pullapart.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import com.pullapart.pagebase.PageBase;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    SeleniumMethods sel = new SeleniumMethods(driver);

    public HomePage clickOnSelectLocation() throws InterruptedException {
        sel.selClickBy(HomePageLocators.SELECT_LOCATION_CONTAINS_TEXT_XPATH);
        return new HomePage(driver);
    }

    public HomePage fillInSearchField(String search) throws InterruptedException {
        sel.selSendKeysBy(HomePageLocators.SELECT_LOCATION_INPUT_FIELD_CSS, search);
        return new HomePage(driver);
    }

    public HomePage selectSearchResult(String search) throws InterruptedException {
        sel.selClickBy(HomePageLocators.selectInputResult(search));
        Thread.sleep(2500);
        return new HomePage(driver);
    }

    public HomePage clickOnSelectMake() {
        sel.selClickBy(HomePageLocators.SELECT_MAKE_XPATH);
        return new HomePage(driver);
    }

    public HomePage clickOnSelectModel() {
        sel.selClickBy(HomePageLocators.SELECT_MODEL_XPATH);
        return new HomePage(driver);
    }

    public InventorySearchPage clickOnSearchButton() {
        sel.selClickBy(HomePageLocators.BASIC_SEARCH_BUTTON_XPATH);
        return new InventorySearchPage(driver);
    }


}
