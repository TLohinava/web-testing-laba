package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopNavigation extends AbstractUIObject {

    @FindBy(xpath = ".//span[@class=\"b-main-navigation__text\"][text()]")
    private List<ExtendedWebElement> menuItemList;

    public TopNavigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<ExtendedWebElement> getMenuItemList() {
        return menuItemList;
    }
}