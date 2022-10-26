package com.solvd.webtesting;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultFrame extends AbstractPage {

    @FindBy(css = "li.search__result")
    private List<SearchResultBlock> searchResultBlockList;

    @FindBy(css = "div.compare-button-container")
    private CompareElement compareElement;

    public ResultFrame(WebDriver driver) {
        super(driver);
    }

    public void compareProducts() {
        compareElement.clickCompareButton();
    }

    public List<SearchResultBlock> getSearchResultBlockList() {
        return searchResultBlockList;
    }

    public CompareElement getCompareElement() {
        return compareElement;
    }
}
