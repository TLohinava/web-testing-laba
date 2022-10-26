package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(css = "form.fast-search__form")
    private SearchForm searchForm;

    @FindBy(css = "iframe.modal-iframe")
    private ExtendedWebElement iframe;

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
}