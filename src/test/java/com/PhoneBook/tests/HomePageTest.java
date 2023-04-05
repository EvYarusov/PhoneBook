package com.PhoneBook.tests;

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
        //app.getHomePage().pause(1000);
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }

}
