package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CompareElement extends AbstractUIObject {

    @FindBy(css = "a.compare-button__sub_control")
    private ExtendedWebElement clearButton;

    @FindBy(css = "a.compare-button__sub_main")
    private ExtendedWebElement compareButton;

    public CompareElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickCompareButton() {
        compareButton.click();
    }

    public ExtendedWebElement getClearButton() {
        return clearButton;
    }

    public ExtendedWebElement getCompareButton() {
        return compareButton;
    }
}
