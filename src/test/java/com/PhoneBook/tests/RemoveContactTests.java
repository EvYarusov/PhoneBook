package com.PhoneBook.tests;

import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    // precondition: 1. Verify user is log out, 2. log in, 3. add contact
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            // click on Login link
            app.getHeader().clickOnLoginLink();

            // fill Login form
            app.getUser().fillLoginRegForm(new User()
                    .setEmail("manul-j@gmail.com")
                    .setPassword("Manul1234$")
            );

            // click on Login button
            app.getUser().clickOnLoginButton();
        }

        // click on Add link
        app.getHeader().clickOnAddLink();

        // fill add contact form
        app.getContact().addContact(new Contact()
                .setName("Mark")
                .setLastName("Karlov")
                .setPhone("1234567890")
                .setEmail("karl@gm.co")
                .setAddress("Marder str.")
                .setDescription("torwart")
        );

        // click on Save button
        app.getContact().clickOnSaveButton();
    }

    @Test(enabled = true)
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();

        //click on Card
        // click on remove button
        app.getContact().removeContact();

        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();

        //verify that contact is removed
        Assert.assertEquals(sizeBefore - sizeAfter, 1);
    }

}
