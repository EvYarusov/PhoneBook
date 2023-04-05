package com.PhoneBook.tests;

import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }
    @Test(priority = 1)
    public void loginRegisteredUserPositiveTest() {
        // click on Login link
        app.getHeader().clickOnLoginLink();
        // verify Login form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        // fill Login form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("manul-j@gmail.com")
                .setPassword("Manul1234$")
        );

        // click on Login button
        app.getUser().clickOnLoginButton();

        // verify User logged in
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test(priority = 2)
    public void loginRegisteredUserWithInvalidPasswordNegativeTest() {
        // click on Login link
        app.getHeader().clickOnLoginLink();

        // verify Login form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        // fill Login form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("manul-j@gmail.com")
                .setPassword("Manul1234")
        );

        // click on Login button
        app.getUser().clickOnLoginButton();

        // verify alert 'Wrong email or password' is appears
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test(priority = 3)
    public void loginRegisteredUserWithInvalidEmailNegativeTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();

        // verify Login form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        // fill Login form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("manul-j@gmail")
                .setPassword("Manul1234$")
        );

        // click on Login button
        app.getUser().clickOnLoginButton();

        // verify alert 'Wrong email or password' is appears
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
    @Test(priority = 4)
    public void loginRegisteredUserWithoutPasswordNegativeTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();

        // verify Login form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        // fill Login form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("manul-j@gmail")
        );

        // click on Login button
        app.getUser().clickOnLoginButton();

        // verify alert 'Wrong email or password' is appears
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}