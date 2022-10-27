package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class OnlinerTest implements IAbstractTest {

    @Test
    public void openHomePageTest() {
        HomePage homePage = new HomePage(getDriver());
        ResultFrame resultFrame = new ResultFrame(getDriver());
        SearchForm searchForm = homePage.getSearchForm();
        List<SearchResultBlock> searchResultBlockList = resultFrame.getSearchResultBlockList();
        String query = "sony";

        homePage.open();

        if (searchForm.isUIObjectPresent()) {
            searchForm.typeSearchInput(query);
        }

        homePage.getDriver().switchTo().frame(homePage.getIframe().getElement());

        SoftAssert sa = new SoftAssert();
        searchResultBlockList.forEach(s -> sa.assertTrue(s.getProductName().getText().contains(query), "Some positions do not contain the query name."));
        sa.assertAll();

        System.out.println();
    }

    @Test
    public void openAboutPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Footer footer = homePage.getFooter();
        footer.clickAboutLink();
    }

    @Test
    public void checkHomePageHeadings() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        List<String> menuItems = homePage.getTopNavigation().getMenuItemList().stream()
                .map(i -> i.getText().replaceAll("\"", ""))
                .collect(Collectors.toList());

        List<ExtendedWebElement> headings = homePage.getSectionHeadingList().stream()
                .filter(i -> menuItems.contains(i.getText()))
                .collect(Collectors.toList());

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(menuItems.size(), headings.size());
        sa.assertAll();
    }

    @Test
    public void checkSocialMediaButtons() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Footer footer = homePage.getFooter();
        List<ExtendedWebElement> smButtonList = footer.getSocialButtonList();
        int arraySize = smButtonList.size();
        ExtendedWebElement[] smButtonArray = smButtonList.toArray(new ExtendedWebElement[arraySize]);

        homePage.clickAny(smButtonArray);
//        homePage.isUrlAsExpected();
    }

    @Test
    public void checkGridByFour() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        List<SectionGrid> sectionGridList = homePage.getSectionGridList();
        List<ExtendedWebElement> sectionGridByFourList = sectionGridList.stream()
                .map(SectionGrid::getSectionGridByFour)
                .collect(Collectors.toList());

        for (ExtendedWebElement section : sectionGridByFourList) {
            section.scrollTo();

            homePage.allElementListsAreNotEmpty(sectionGridList.get(sectionGridByFourList.indexOf(section)).getTeaserList());
        }
    }
}