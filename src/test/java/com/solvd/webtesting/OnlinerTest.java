package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class OnlinerTest implements IAbstractTest {

    @Test
    public void openHomePageTest() {
        HomePage homePage = new HomePage(getDriver());
        ResultFrame resultFrame = new ResultFrame(getDriver());
        SearchForm searchForm = homePage.getSearchForm();
        List<SearchResultBlock> searchResultBlockList = resultFrame.getSearchResultBlockList();

        homePage.open();

        if (searchForm.isUIObjectPresent()) {
            searchForm.typeSearchInput("sony");

        }

//        homePage.switchWindow();
        homePage.getDriver().switchTo().frame(homePage.getIframe().getElement());

//        SoftAssert sa = new SoftAssert();
//        searchResultBlockList.forEach(s -> sa.assertTrue(s.getProductImage().isPresent()));
//        sa.assertAll();

        searchResultBlockList.forEach(s -> s.getCheckBox().check());

        if (searchResultBlockList.stream()
                .anyMatch(s -> s.getCheckBox().isChecked())) {
            resultFrame.compareProducts();
            getDriver().switchTo().defaultContent();
        }


        System.out.println();
    }
}
