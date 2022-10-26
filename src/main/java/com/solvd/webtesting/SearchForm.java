package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchForm extends AbstractUIObject {

    @FindBy(css = "input.fast-search__input")
    private ExtendedWebElement searchInput;

    public SearchForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeSearchInput(String query) {
        searchInput.type(query);
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }
}