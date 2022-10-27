package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
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

        homePage.getDriver().switchTo().frame(homePage.getIframe().getElement());

        searchResultBlockList.forEach(s -> s.clickCheckbox());
//
//        SoftAssert sa = new SoftAssert();
//        searchResultBlockList.forEach(s -> sa.assertTrue(s.getProductImage().isPresent()));
//        sa.assertAll();
//
//        searchResultBlockList.forEach(s -> sa.assertTrue(s.getProductReviews().getText().equals("zz")));
//        sa.assertAll();

        System.out.println();
    }

    @Test
    public void openAboutPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Footer footer = homePage.getFooter();
        footer.clickAboutLink();

    }
}
