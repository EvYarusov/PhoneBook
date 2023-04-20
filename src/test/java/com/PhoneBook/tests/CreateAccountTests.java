package com.PhoneBook.tests;

import com.ait.phonebook.fw.DataProviderUser;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(priority = 1, enabled = true)
    public void newUserRegistrationPositiveTest() {

        app.getHeader().clickOnLoginLink();

        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        app.getUser().fillLoginRegForm(new User()
                .setEmail("manul-j@gmail.com")
                .setPassword("Manul1234$")
        );

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }
    @Test(priority = 2, enabled = true, dataProvider = "addNewUserWithInvalidPasswordFromCSV",
            dataProviderClass = DataProviderUser.class)
    public void newUserRegistrationWithInvalidPasswordNegativeTest(User user) {

        app.getHeader().clickOnLoginLink();

        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        app.getUser().fillLoginRegForm(user);

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
