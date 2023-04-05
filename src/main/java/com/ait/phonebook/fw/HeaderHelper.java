package com.ait.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends BaseHelper {
    public HeaderHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresentByLocator(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresentByLocator(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickOnAddLink() {
        click(By.cssSelector("a:nth-child(5)"));
    }
}
