package com.PhoneBook.tests;

import com.ait.phonebook.fw.DataProviderUser;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //precondition: user shulde be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(enabled = false) //второй раз уже не сможем зарегистрировать пользователя
    public void newUserRegistrationPositiveTest() {
        // click on Login link
        app.getHeader().clickOnLoginLink();
        // verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        // fill registration form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("manul-j@gmail.com")
                .setPassword("Manul1234$")
        );

        //click on Registration button
        app.getUser().clickOnRegistrationButton();

        //verify Sign out button is displayed
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }
    @Test(enabled = true, dataProvider = "addNewUserWithInvalidPasswordFromCSV",
            dataProviderClass = DataProviderUser.class)
    public void newUserRegistrationWithInvalidPasswordNegativeTest(User user) {

        app.getHeader().clickOnLoginLink();

        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        app.getUser().fillLoginRegForm(user);

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
