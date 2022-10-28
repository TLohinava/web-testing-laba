package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer extends AbstractUIObject {

    @FindBy(xpath = "//*[@href=\"https://blog.onliner.by/about\"]")
    private ExtendedWebElement aboutLink;

    @FindBy(css = "a.footer-style__social-button")
    private List<ExtendedWebElement> socialButtonList;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickAboutLink() {
        aboutLink.click();
    }

    public ExtendedWebElement getAboutLink() {
        return aboutLink;
    }

    public List<ExtendedWebElement> getSocialButtonList() {
        return socialButtonList;
    }
}