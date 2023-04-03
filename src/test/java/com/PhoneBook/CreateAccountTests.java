package com.PhoneBook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //precondition: user shulde be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test(enabled = false) //второй раз уже не сможем зарегистрировать пользователя
    public void newUserRegistrationPositiveTest() {
        // click on Login link
        clickOnLoginLink();
        // verify Registration form is displayed
        Assert.assertTrue(isLoginRegFormPresent());
        // fill registration form
        fillLoginRegForm("manul-j@gmail.com", "Manul1234$");

        //click on Registration button
        clickOnRegistrationButton();

        //verify Sign out button is displayed
        Assert.assertTrue(isSignOutButtonPresent());
    }

}
