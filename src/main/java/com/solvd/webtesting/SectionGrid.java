package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SectionGrid extends AbstractUIObject {

    @FindBy(xpath = ".//ul[contains(@class, \"b-teasers-2\")]")
    private ExtendedWebElement sectionGridByFour;

    @FindBy(xpath = ".//li[@class=\"b-teasers-2__teaser\"]")
    private List<ExtendedWebElement> teaserList;

    @FindBy(xpath = ".//header[contains(@class, \"b-main-page-blocks-header-2\")]")
    private ExtendedWebElement sectionHeading;

    @FindBy(xpath = ".//a[@class=\"footer-3-button\"]")
    private ExtendedWebElement newsButton;

    public SectionGrid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement[] getTeaserArray() {
        int size = teaserList.size();
        return teaserList.toArray(new ExtendedWebElement[size]);
    }

    public List<ExtendedWebElement> getTeaserList() {
        return teaserList;
    }

    public ExtendedWebElement getSectionHeading() {
        return sectionHeading;
    }

    public ExtendedWebElement getSectionGridByFour() {
        return sectionGridByFour;
    }

    public ExtendedWebElement getNewsButton() {
        return newsButton;
    }
}