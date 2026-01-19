package com.pullapart.locators;

import org.openqa.selenium.By;

public class UsedCarsPageLocators {

    public static final By WHERE_WE_SELL_USED_CARS_H2_XPATH = By.xpath("//h2[contains(text(),'Where We Sell Used Cars')]");

    public static final By ENTER_ZIP_CODE_XPAH =    By.xpath("//input[@data-form-input = 'zipCode']");

    public static final By SUBMIT_BUTTON_XPATH = By.xpath("//button[contains(text(), 'Sub')]");

    public static final By RESULTS_DISPLAY_BANNER_WHERE_WE_SELL = By.xpath("//h2[contains(text(), 'Where We Sell')]");

    public static final By USED_CARS_LOCATION_RESULTS = By.xpath("//div[@data-form-search='result']/div");

}
