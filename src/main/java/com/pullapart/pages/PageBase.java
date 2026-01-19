package com.pullapart.pages;

import com.pullapart.helper.Waits;
import com.pullapart.locators.CommonLocators;
import com.pullapart.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;

public class PageBase {
    protected WebDriver driver;
    protected Waits wait;
    protected SeleniumMethods sel;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        this.sel = new SeleniumMethods(driver, wait);
    }

    public FAQPage navigateToFaqPage() {
        sel.selClickBy(CommonLocators.FAQ_LINK_XPATH);
        return new FAQPage(driver);
    }

    public UsedCarsPage navigateToUsedCarsPage() {
        sel.selClickBy(CommonLocators.USED_CARS_LINK_XPATH);
        return new UsedCarsPage(driver);
    }

    public VIPClubPage navigateToVIPClubPage() {
        sel.selClickBy(CommonLocators.VIP_CLUB_LINK_XPATH);
        return new VIPClubPage(driver);
    }

}
