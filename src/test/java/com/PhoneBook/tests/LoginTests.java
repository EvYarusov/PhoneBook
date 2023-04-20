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
    @Test(priority = 1, enabled = true)
    public void loginRegisteredUserPositiveTest() {

        app.getHeader().clickOnLoginLink();

        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        app.getUser().fillLoginRegForm(new User()
                .setEmail("manul-j@gmail.com")
                .setPassword("Manul1234$")
        );

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
        logger.info("User logged in. Actual result: " + app.getHeader().isSignOutButtonPresent() + ". Expected result: true");
    }

    @Test(priority = 2, enabled = true)
    public void loginRegisteredUserWithInvalidPasswordNegativeTest() {

        app.getHeader().clickOnLoginLink();

        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        app.getUser().fillLoginRegForm(new User()
                .setEmail("manul-j@gmail.com")
                .setPassword("Manul1234")
        );

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test(priority = 3, enabled = true)
    public void loginRegisteredUserWithInvalidEmailNegativeTest() {

        app.getHeader().clickOnLoginLink();

        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        app.getUser().fillLoginRegForm(new User()
                .setEmail("manul-j@gmail")
                .setPassword("Manul1234$")
        );

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertPresent());
    }
    @Test(priority = 4, enabled = true)
    public void loginRegisteredUserWithoutPasswordNegativeTest() {

        app.getHeader().clickOnLoginLink();

        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        app.getUser().fillLoginRegForm(new User()
                .setEmail("manul-j@gmail")
        );

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertPresent());

    }
}
