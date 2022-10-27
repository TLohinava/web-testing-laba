package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject {

    @FindBy(xpath="//*[@href=\"https://blog.onliner.by/about\"]")
    private ExtendedWebElement aboutLink;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickAboutLink() {
        aboutLink.click();
    }

    public ExtendedWebElement getAboutLink() {
        return aboutLink;
    }
}
