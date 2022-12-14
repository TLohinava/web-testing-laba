package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(css = "form.fast-search__form")
    private SearchForm searchForm;

    @FindBy(xpath = "//*[@class='modal-iframe']")
    private ExtendedWebElement iframe;

    @FindBy(tagName = "footer")
    private Footer footer;

    @FindBy(xpath = ".//*[contains(@class,'b-main-page-news') and contains(@class, 'b-main-page-grid')]")
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

    public List<SectionGrid> getSectionGridList() {
        return sectionGridList;
    }
}