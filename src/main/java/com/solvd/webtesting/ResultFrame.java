package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultFrame extends AbstractPage {

    @FindBy(xpath = ".//span[@class='search__close']")
    private ExtendedWebElement closingButton;

    @FindBy(xpath = ".//*[contains(@class, 'search__tabs-item')]")
    private List<ExtendedWebElement> searchTabs;

    public ResultFrame(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getClosingButton() {
        return closingButton;
    }

    public List<ExtendedWebElement> getSearchTabs() {
        return searchTabs;
    }
}