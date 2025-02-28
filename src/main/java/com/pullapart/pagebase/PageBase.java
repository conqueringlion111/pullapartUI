package com.pullapart.pagebase;

import com.pullapart.locators.CommonLocators;
import com.pullapart.pages.FAQPage;
import com.pullapart.pages.UsedCarsPage;
import com.pullapart.pages.VIPClubPage;
import com.pullapart.utils.SeleniumMethods;
import org.openqa.selenium.WebDriver;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public FAQPage navigateToFaqPage() {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(CommonLocators.FAQ_LINK_XPATH);
        return new FAQPage(driver);
    }

    public UsedCarsPage navigateToUsedCarsPage() {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(CommonLocators.USED_CARS_LINK_XPATH);
        return new UsedCarsPage(driver);
    }

    public VIPClubPage navigateToVIPClubPage() {
        SeleniumMethods sel = new SeleniumMethods(driver);
        sel.selClickBy(CommonLocators.VIP_CLUB_LINK_XPATH);
        return new VIPClubPage(driver);
    }

}
