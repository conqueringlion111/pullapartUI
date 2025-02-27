package com.pullapart.locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static final By SELECT_LOCATION_XPATH = By.xpath("//span[@id='select2-location-te-container']");
    public static final By SELECT_LOCATION_CONTAINS_TEXT_XPATH = By.xpath("//span[contains(text(),'Select Location')]");
    public static final By SELECT_LOCATION_INPUT_FIELD_XPATH = By.xpath("//input[@class='select2-search__field']");
    public static final By SELECT_LOCATION_INPUT_FIELD_CSS = By.cssSelector(".select2-search__field");

    public static By selectInputResult(String location) {
        return By.xpath("//li[contains(text(),'" + location + "')]");
    }
    public static final By SELECT_MAKE_XPATH = By.xpath("//span[contains(text(),'Select Make')]");
    public static final By INPUT_FIELD_CSS = By.cssSelector(".select2-search__field");
    public static final By SELECT_MODEL_XPATH = By.xpath("//span[contains(text(),'Select Model')]");
    public static final By BASIC_SEARCH_BUTTON_XPATH = By.xpath("//div[@class='basic-search']//button[contains(text(),'SEARCH')]");

}
