package com.PhoneBook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    // precondition: 1. Verify user is log out, 2. log in, 3. add contact
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

        // click on Add link
        clickOnAddLink();

        // fill add contact form
        addContact("Mark", "Karlov", "1234567890", "karl@gm.co", "Marder str.", "torwart");

        // click on Save button
        clickOnSaveButton();
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContacts();

        //click on Card
        // click on remove button
        removeContact();

        pause(1000);
        int sizeAfter = sizeOfContacts();

        //verify that contact is removed
        Assert.assertEquals(sizeBefore - sizeAfter, 1);
    }

}
