package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class OnlinerTest implements IAbstractTest {

    HomePage homePage;

    @BeforeMethod
    public void startTest() {
        homePage = new HomePage(getDriver());
        homePage.open();
    }

    @Test
    public void openHomePageSearchTest() {
        ResultFrame resultFrame = new ResultFrame(getDriver());
        SearchForm searchForm = homePage.getSearchForm();
        String query = "sony";

        if (searchForm.isUIObjectPresent()) {
            searchForm.typeSearchInput(query);
        }

        getDriver().switchTo().frame(homePage.getIframe().getElement());

        resultFrame.getSearchTabs()
                .forEach(tab -> {
                    tab.click();
                    pause(2L);
                });

        resultFrame.getClosingButton().click();
        getDriver().switchTo().defaultContent();
    }

    @Test
    public void openAboutPageTest() {
        AboutPage aboutPage = new AboutPage(getDriver());
        Footer footer = homePage.getFooter();
        footer.clickAboutLink();
        Assert.assertTrue(homePage.isUrlAsExpected(aboutPage.getPageURL()));
    }

    @Test
    public void checkSectionHeadingsTest() {
        SoftAssert sa = new SoftAssert();

        for (SectionGrid section : homePage.getSectionGridList()) {
            ExtendedWebElement heading = section.getSectionHeading();
            sa.assertTrue(section.isElementWithTextPresent(heading, heading.getText()), "Section does not contain any heading.");
        }
        sa.assertAll();
    }

    @Test
    public void checkSectionButtonsTest() {
        List<SectionGrid> list = homePage.getSectionGridList();
        List<ExtendedWebElement> buttons = list.stream()
                .map(SectionGrid::getNewsButton)
                .collect(Collectors.toList());

        int size = buttons.size();
        ExtendedWebElement[] buttonArray = buttons.toArray(new ExtendedWebElement[size]);

        homePage.clickAny(buttonArray);

        homePage.navigateBack();
        homePage.isUrlAsExpected(homePage.getPageURL());
    }

    @Test
    public void checkGridByFourTest() {
        List<SectionGrid> sectionGridList = homePage.getSectionGridList();
        List<ExtendedWebElement> sectionGridByFourList = sectionGridList.stream()
                .map(SectionGrid::getSectionGridByFour)
                .collect(Collectors.toList());

        SoftAssert sa = new SoftAssert();

        for (ExtendedWebElement section : sectionGridByFourList) {
            int index = sectionGridByFourList.indexOf(section);

            section.scrollTo();

            sa.assertTrue(homePage.allElementsPresent(sectionGridList.get(index).getTeaserArray()), "Section does not contain all the grid elements");
        }
        sa.assertAll();
    }
}