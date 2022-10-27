package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(css = "form.fast-search__form")
    private SearchForm searchForm;

    @FindBy(xpath = "//*[@class=\"modal-iframe\"]")
    private ExtendedWebElement iframe;

    @FindBy(tagName = "footer")
    private Footer footer;

    @FindBy(css = "header.g-top")
    private TopNavigation topNavigation;

    @FindBy(xpath = "//*[contains(@class, \"b-main-page-blocks-header-2\")]/h2/a[text()]")
    private List<ExtendedWebElement> sectionHeadingList;

    @FindBy(xpath = ".//*[@class=\"b-main-page-grid-4 b-main-page-news-2\"]")
    private List<SectionGrid> sectionGridList;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    public SearchForm getSearchForm() {
        return searchForm;
    }

    public ExtendedWebElement getIframe() {
        return iframe;
    }

    public Footer getFooter() {
        return footer;
    }

    public TopNavigation getTopNavigation() {
        return topNavigation;
    }

    public List<ExtendedWebElement> getSectionHeadingList() {
        return sectionHeadingList;
    }

    public List<SectionGrid> getSectionGridList() {
        return sectionGridList;
    }
}