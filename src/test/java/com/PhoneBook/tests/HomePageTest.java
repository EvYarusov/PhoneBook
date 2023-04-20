package com.PhoneBook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @Test(enabled = true)
    public void openHomePageTest(){

        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }

}
