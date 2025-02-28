package com.pullapart.pages;

import com.pullapart.locators.HomePageLocators;
import com.pullapart.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import com.pullapart.pagebase.PageBase;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage clickOnSelectLocation() throws InterruptedException {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(HomePageLocators.SELECT_LOCATION_CONTAINS_TEXT_XPATH);
        return new HomePage(driver);
    }

    public HomePage fillInSearchField(String search) throws InterruptedException {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selSendKeysBy(HomePageLocators.SELECT_LOCATION_INPUT_FIELD_XPATH, search);
        return new HomePage(driver);
    }

    public HomePage selectSearchResult(String search) throws InterruptedException {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(HomePageLocators.selectInputResult(search));
        Thread.sleep(2500);
        return new HomePage(driver);
    }

    public HomePage clickOnSelectMake() {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(HomePageLocators.SELECT_MAKE_XPATH);
        return new HomePage(driver);
    }

    public HomePage clickOnSelectModel() {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(HomePageLocators.SELECT_MODEL_XPATH);
        return new HomePage(driver);
    }

    public InventorySearchPage clickOnSearchButton() {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(HomePageLocators.BASIC_SEARCH_BUTTON_XPATH);
        return new InventorySearchPage(driver);
    }

    public FAQPage clickOnFAQLink() {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(HomePageLocators.FAQ_LINK_XPATH);
        return new FAQPage(driver);
    }


}
