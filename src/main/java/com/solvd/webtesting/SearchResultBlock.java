package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultBlock extends AbstractUIObject {

    @FindBy(css = "img.product__image")
    private ExtendedWebElement productImage;

    @FindBy(xpath = ".//*[@class=\"product__compare\"]")
    private ExtendedWebElement checkBox;

    @FindBy(xpath = ".//*[contains(@class, \"product__reviews\")][text()]")
    private ExtendedWebElement productReviews;

    @FindBy(xpath = ".//*[contains(@class, \"product__title-link\")][text()]")
    private ExtendedWebElement productName;

    public SearchResultBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickCheckbox() {
        checkBox.check();
    }

    public ExtendedWebElement getProductImage() {
        return productImage;
    }

    public ExtendedWebElement getCheckBox() {
        return checkBox;
    }

    public ExtendedWebElement getProductReviews() {
        return productReviews;
    }

    public ExtendedWebElement getProductName() {
        return productName;
    }
}