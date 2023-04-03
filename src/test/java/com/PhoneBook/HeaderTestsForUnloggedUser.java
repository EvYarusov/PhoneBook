package com.PhoneBook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTestsForUnloggedUser extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresentByLocator(
                By.cssSelector("div.navbar-component_nav__1X_4m a[href='/login']"))
        ) {
            clickOnSignOutButton();
        }
    }
    @Test
    public void checkHeaderLogoTest() {
        Assert.assertTrue(
                isElementPresentByLocator(
                        By.xpath("//div[@class='navbar-component_nav__1X_4m']/h1[contains(.,'PHONEBOOK')]")
                )
        );
    }
    @Test
    public void checkHeaderHomeLinkTest() {
        Assert.assertTrue(
                isElementPresentByLocator(
                        By.cssSelector("div.navbar-component_nav__1X_4m a[href='/home']")
                )
        );
    }
    @Test
    public void checkHeaderAboutLinkTest() {
        Assert.assertTrue(
                isElementPresentByLocator(
                        By.cssSelector("div.navbar-component_nav__1X_4m a[href='/about']")
                )
        );
    }
    @Test
    public void checkHeaderLoginLinkTest() {
        Assert.assertTrue(
                isElementPresentByLocator(
                        By.cssSelector("div.navbar-component_nav__1X_4m a[href='/login']")
                )
        );
    }
}
