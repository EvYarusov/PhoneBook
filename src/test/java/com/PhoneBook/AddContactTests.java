package com.PhoneBook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    // preconditions: 1. User is logged out, 2. log in
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        } else {
            // click on Login link
            clickOnLoginLink();

            // fill Login form
            fillLoginRegForm("manul-j@gmail.com", "Manul1234$");

            // click on Login button
            clickOnLoginButton();
        }
    }

    @Test(priority = 1)
    public void addContactPositiveTest() {
        // click on Add link
        clickOnAddLink();

        // fill add contact form
        addContact("Mark", "Karlov", "1234567890", "mark@gm.co", "Marder str.", "torwart");

        // click on Save button
        clickOnSaveButton();

        //verify new contact is added
        Assert.assertTrue(isContactCreated("Mark"));
    }

    @Test(priority = 2)
    public void addContactNegativeTest() {
        // click on Add link
        clickOnAddLink();

        // fill Add contact form
        addContact("Bob", "Robson", "instead of number", "BoRo@gm.co", "Newport str.", "wrong entry");

        // click on Save button
        clickOnSaveButton();

        //verify alert 'Phone not valid: Phone number must contain only digits! And length min 10, max 15!' ia appears
        Assert.assertTrue(isAlertPresent());
    }
}
