package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultBlock extends AbstractUIObject {

    @FindBy(css = "img.product__image")
    private ExtendedWebElement productImage;

    @FindBy(css = "span.i-checkbox__faux")
    private ExtendedWebElement checkBox;

    public SearchResultBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductImage() {
        return productImage;
    }

    public ExtendedWebElement getCheckBox() {
        return checkBox;
    }
}
