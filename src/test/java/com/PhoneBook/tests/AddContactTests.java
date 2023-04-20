package com.PhoneBook.tests;

import com.ait.phonebook.fw.DataProviderContact;
import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getHeader().clickOnLoginLink();

            app.getUser().fillLoginRegForm(new User()
                    .setEmail("manul-j@gmail.com")
                    .setPassword("Manul1234$")
            );

            app.getUser().clickOnLoginButton();
        }
    }

    @Test(priority = 1, enabled = true)
    public void addContactPositiveTest() {
        app.getHeader().clickOnAddLink();

        app.getContact().addContact(new Contact()
                .setName("Mark")
                .setLastName("Karlov")
                .setPhone("1234567890")
                .setEmail("mark@gm.co")
                .setAddress("Marder str.")
                .setDescription("torwart")
        );

        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactCreated("Mark"));
    }

    @Test(priority = 2, enabled = true)
    public void addContactNegativeTest() {
        app.getHeader().clickOnAddLink();

        app.getContact().addContact(new Contact()
                .setName("Bob")
                .setLastName("Robson")
                .setPhone("instead of number")
                .setEmail("BoRo@gm.co")
                .setAddress("Newport str.")
                .setDescription("wrong entry")
        );

        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isAlertPresent());
    }

    @Test(priority = 3, enabled = true, dataProvider = "addNewContact", dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromDataProviderTest(String name, String lastName, String phone,
                                                       String email, String address, String description) {

        app.getHeader().clickOnAddLink();

        app.getContact().addContact(new Contact()
                .setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description)
        );

        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();
    }

    @Test(priority = 4, enabled = true, dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromCSVFileTest(Contact contact) {

        app.getHeader().clickOnAddLink();

        app.getContact().addContact(contact);

        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();
    }

}
