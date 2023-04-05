package com.PhoneBook.tests;

import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    // preconditions: 1. User is logged out, 2. log in
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
    }

    @Test(priority = 1)
    public void addContactPositiveTest() {
        //TODO добавить паузу
        app.getContact().pause(1000);
        // click on Add link
        app.getHeader().clickOnAddLink();

        // fill add contact form
        app.getContact().addContact(new Contact()
                .setName("Mark")
                .setLastName("Karlov")
                .setPhone("1234567890")
                .setEmail("mark@gm.co")
                .setAddress("Marder str.")
                .setDescription("torwart")
        );

        // click on Save button
        app.getContact().clickOnSaveButton();

        //verify new contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Mark"));
    }

    @Test(priority = 2)
    public void addContactNegativeTest() {
        //TODO добавить паузу для clickOnAddLink
        app.getContact().pause(1000);
        // click on Add link
        app.getHeader().clickOnAddLink();

        // fill Add contact form
        app.getContact().addContact(new Contact()
                .setName("Bob")
                .setLastName("Robson")
                .setPhone("instead of number")
                .setEmail("BoRo@gm.co")
                .setAddress("Newport str.")
                .setDescription("wrong entry")
        );

        // click on Save button
        app.getContact().clickOnSaveButton();

        //verify alert 'Phone not valid: Phone number must contain only digits! And length min 10, max 15!' ia appears
        Assert.assertTrue(app.getContact().isAlertPresent());
    }
}
