package com.PhoneBook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @Test
    public void openHomePageTest(){
        //verify to display Home Component form
        //isHomeComponentPresent();
        //System.out.println("Home Component is " + isHomeComponentPresent());
        //isHomeComponentPresent2();
        //isElementPresentByLocator(By.cssSelector("div:nth-child(2)>div>div"));
        //isElementPresentByLocator2(By.cssSelector("div:nth-child(2)>div>div"));
        Assert.assertTrue(isElementPresentByLocator2(By.cssSelector("div:nth-child(2)>div>div")));
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size()>0;
    }

    public boolean isHomeComponentPresent2() {
        try {
            driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

}
