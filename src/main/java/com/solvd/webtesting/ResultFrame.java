package com.solvd.webtesting;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultFrame extends AbstractPage {

    @FindBy(xpath = "//*[@class=\"search__result\"]")
    private List<SearchResultBlock> searchResultBlockList;

    public ResultFrame(WebDriver driver) {
        super(driver);
    }

    public List<SearchResultBlock> getSearchResultBlockList() {
        return searchResultBlockList;
    }

}
