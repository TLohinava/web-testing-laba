package com.solvd.webtesting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends AbstractPage {

    @FindBy(xpath = "//a[@href=\"mailto:info@onliner.by\"]")
    private ExtendedWebElement infoMail;

    public AboutPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://blog.onliner.by/about");
    }

    public ExtendedWebElement getInfoMail() {
        return infoMail;
    }
}