package com.ait.phonebook.fw;

import com.ait.phonebook.model.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"John", "Parker", "4561239789", "JPa@gm.com", "Paris", "forward"});
        list.add(new Object[]{"John2", "Parker", "4567891231", "JPa2@gm.com", "Paris", "forward"});
        list.add(new Object[]{"John3", "Parker", "4567891232", "JPa3@gm.com", "Paris", "forward"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/phonebookContacts.csv"))
        );
        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setLastName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])}
            );
            line = reader.readLine();
        }

        return list.iterator();
    }
}
