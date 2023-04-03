package com.PhoneBook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }
    @Test(priority = 1)
    public void loginRegisteredUserPositiveTest() {
        // click on Login link
        clickOnLoginLink();
        // verify Login form is displayed
        Assert.assertTrue(isLoginRegFormPresent());
        // fill Login form
        fillLoginRegForm("manul-j@gmail.com", "Manul1234$");

        // click on Login button
        clickOnLoginButton();

        // verify User logged in
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test(priority = 2)
    public void loginRegisteredUserWithInvalidPasswordNegativeTest() {
        // click on Login link
        clickOnLoginLink();

        // verify Login form is displayed
        Assert.assertTrue(isLoginRegFormPresent());

        // fill Login form
        fillLoginRegForm("manul-j@gmail.com", "Manul1234");

        // click on Login button
        clickOnLoginButton();

        // verify alert 'Wrong email or password' is appears
        Assert.assertTrue(isAlertPresent());
    }

    @Test(priority = 3)
    public void loginRegisteredUserWithInvalidEmailNegativeTest() {
        //click on Login link
        clickOnLoginLink();

        // verify Login form is displayed
        Assert.assertTrue(isLoginRegFormPresent());

        // fill Login form
        fillLoginRegForm("manul-j@gmail", "Manul1234$");

        // click on Login button
        clickOnLoginButton();

        // verify alert 'Wrong email or password' is appears
        Assert.assertTrue(isAlertPresent());
    }
}
