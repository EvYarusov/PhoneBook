package com.PhoneBook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UnloggedUserHeaderTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isElementPresentByLocator(
                By.cssSelector("div.navbar-component_nav__1X_4m a[href='/login']"))
        ) {
            app.getHeader().clickOnSignOutButton();
        }
    }
    @Test(priority = 1, enabled = true)
    public void checkHeaderLogoTest() {
        Assert.assertTrue(
                app.getHeader().isElementPresentByLocator(
                        By.xpath("//div[@class='navbar-component_nav__1X_4m']/h1[contains(.,'PHONEBOOK')]")
                )
        );
    }
    @Test(priority = 2, enabled = true)
    public void checkHeaderHomeLinkTest() {
        Assert.assertTrue(
                app.getHeader().isElementPresentByLocator(
                        By.cssSelector("div.navbar-component_nav__1X_4m a[href='/home']")
                )
        );
    }
    @Test(priority = 3, enabled = true)
    public void checkHeaderAboutLinkTest() {
        Assert.assertTrue(
                app.getHeader().isElementPresentByLocator(
                        By.cssSelector("div.navbar-component_nav__1X_4m a[href='/about']")
                )
        );
    }
    @Test(priority = 4, enabled = true)
    public void checkHeaderLoginLinkTest() {
        Assert.assertTrue(
                app.getHeader().isElementPresentByLocator(
                        By.cssSelector("div.navbar-component_nav__1X_4m a[href='/login']")
                )
        );
    }
}
